package stas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stas.entities.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
