package stas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import stas.dto.Test;
import stas.entities.StoEntity;

import java.util.List;
import java.util.Optional;

public interface StoRep extends JpaRepository<StoEntity, Long> {

    Optional<StoEntity> findByName(String name);

    @Query(value = "SELECT new stas.dto.Test(sto.name, stoCell.cellRemainder, cell.number) FROM StoEntity as sto, StoCellEntity as stoCell, CellEntity as cell WHERE stoCell.cell = cell and stoCell.sto = sto and cell.number = :number")
    List<Test> findAllByCellNumber(@Param("number") Long cellNumber);
}
