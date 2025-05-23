package br.gabnsoares.marketplace.repository;

import br.gabnsoares.marketplace.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
