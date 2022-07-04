package ir.sudoit.infrastructure.persistence.repositories;

import ir.sudoit.infrastructure.persistence.entities.PersonEntity;
import ir.sudoit.infrastructure.persistence.repositories.base.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends BaseJpaRepository<PersonEntity, Long> {
}
