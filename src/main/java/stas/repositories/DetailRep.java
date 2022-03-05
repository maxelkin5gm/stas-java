package stas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stas.entities.DetailEntity;

import java.util.Optional;


public interface DetailRep extends JpaRepository<DetailEntity, Long> {
    Optional<DetailEntity> findByNameAndOperationNumber(String name, String operationNumber);
}

