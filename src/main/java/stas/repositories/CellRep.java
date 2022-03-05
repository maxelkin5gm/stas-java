package stas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import stas.dto.Test;
import stas.dto.Test2;
import stas.entities.CellEntity;

import java.util.List;
import java.util.Optional;

public interface CellRep extends JpaRepository<CellEntity, Long> {

    Optional<CellEntity> findByNumber(Long number);

    @Query(value = "" +
            "SELECT new stas.dto.Test(sto.name, stoCell.cellRemainder, cell.number) " +
            "FROM StoEntity as sto, StoCellEntity as stoCell, CellEntity as cell " +
            "WHERE stoCell.cell = cell and stoCell.sto = sto and sto.name = :name")
    List<Test> findAllByStoName(@Param("name") String stoName);

    @Query(value = "" +
            "SELECT new stas.dto.Test2(detail.name, detail.operationNumber, sto.name, stoCell.cellRemainder, cell.number) " +
            "FROM DetailEntity detail, StoCellEntity stoCell, CellEntity cell " +
            "JOIN detail.stos sto " +
            "WHERE stoCell.cell = cell and stoCell.sto = sto and detail.name = :name and detail.operationNumber = :operationNumber ")
    List<Test2> findAllByDetail(@Param("name") String detailName, @Param("operationNumber") String detailOperationNumber);

}
