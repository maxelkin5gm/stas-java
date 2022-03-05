package stas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stas.entities.CellEntity;
import stas.entities.id.StoCellKey;
import stas.entities.StoCellEntity;
import stas.entities.StoEntity;

import java.util.Optional;

public interface StoCellRep extends JpaRepository<StoCellEntity, Long> {

    Optional<StoCellEntity> findByStoAndCell(StoEntity sto, CellEntity cell);


}
