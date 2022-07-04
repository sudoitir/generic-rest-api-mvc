package ir.sudoit.infrastructure.persistence.repositories.base;

import ir.sudoit.infrastructure.persistence.entities.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BaseJpaRepository<T extends BaseEntity<K>, K extends Serializable> extends JpaRepository<T, K> {
}
