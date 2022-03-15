package stas.services.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stas.entities.CellEntity;
import stas.entities.StoCellEntity;
import stas.entities.StoEntity;
import stas.repositories.CellRep;
import stas.repositories.StoCellRep;
import stas.repositories.StoRep;

@Service
@AllArgsConstructor
public class StoCellService {

    StoRep stoRep;
    CellRep cellRep;
    StoCellRep stoCellRep;

    @Transactional
    public boolean addStoInCell(String nameSto, Long cellNumber, Long cellRemainder) {
        try {
            var sto = stoRep.findByName(nameSto).orElse(new StoEntity(nameSto));

            var cell = cellRep.findByNumber(cellNumber).orElse(new CellEntity(cellNumber));

            cellRep.save(cell);
            stoRep.save(sto);

            var stoCell = stoCellRep.findByStoAndCell(sto, cell);
            if (stoCell.isPresent()) {
                return false;
            }

            var stoCellEntity = new StoCellEntity(sto, cell, cellRemainder);
            cell.getStoCells().add(stoCellEntity);
            sto.getStoCells().add(stoCellEntity);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
