package ir.sudoit.infrastructure.person.persistence.repository;

import ir.sudoit.infrastructure.crud.persistence.repositories.BaseRepo;
import ir.sudoit.infrastructure.person.persistence.entity.PersonEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends BaseRepo<PersonEntity, Long> {
}
