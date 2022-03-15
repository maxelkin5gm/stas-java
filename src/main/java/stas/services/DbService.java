package stas.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stas.entities.CellEntity;
import stas.entities.DetailEntity;
import stas.entities.StoCellEntity;
import stas.entities.StoEntity;
import stas.repositories.CellRep;
import stas.repositories.DetailRep;
import stas.repositories.StoCellRep;
import stas.repositories.StoRep;

@Service
@AllArgsConstructor
public class DbService {

    DetailRep detailRep;
    StoRep stoRep;
    CellRep cellRep;
    StoCellRep stoCellRep;

    @Transactional
    public void add(String nameDetail, String operationNumber, String nameSto, Long cellRemainder, Long cellNumber) {

        var sto = stoRep.findByName(nameSto).orElse(new StoEntity(nameSto));

        var detail = detailRep.findByNameAndOperationNumber(nameDetail, operationNumber)
                .orElse(new DetailEntity(nameDetail, operationNumber));

        var cell = cellRep.findByNumber(cellNumber).orElse(new CellEntity(cellNumber));

        stoRep.save(sto);

        detailRep.save(detail);
        detail.addSto(sto);

        cellRep.save(cell);

        var stoCell = stoCellRep.findByStoAndCell(sto, cell).orElse(new StoCellEntity(sto, cell, cellRemainder));
        stoCell.setCellRemainder(cellRemainder);
        cell.getStoCells().add(stoCell);
        sto.getStoCells().add(stoCell);

        stoRep.flush();
        detailRep.flush();
        cellRep.flush();
    }


    @Transactional
    public void deleteStoFromCell(String nameSto, Long cellNumber) {
        var stoCellExample = new StoCellEntity();
        stoCellExample.setSto(new StoEntity(nameSto));
        stoCellExample.setCell(new CellEntity(cellNumber));

        var stoCell = stoCellRep.findOne(Example.of(stoCellExample)).get();

        stoCellRep.delete(stoCell);


    }
}
