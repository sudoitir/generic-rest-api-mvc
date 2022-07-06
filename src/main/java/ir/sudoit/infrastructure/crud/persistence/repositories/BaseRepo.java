package ir.sudoit.infrastructure.crud.persistence.repositories;

import ir.sudoit.infrastructure.crud.persistence.model.IdentifiableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;

@Transactional
@NoRepositoryBean
public interface BaseRepo<T extends IdentifiableEntity<ID>, ID extends Serializable> extends CrudRepo<T, ID>, JpaRepository<T, ID> {

    @NonNull
    @Override
    default T create(@NonNull final T entity) {
        Objects.requireNonNull(entity, "The given entity must not be null!");
        return save(entity);
    }

    @Transactional(readOnly = true)
    @NonNull
    Optional<T> getToUpdateById(@NonNull ID id);

    @NonNull
    @Override
    default <S> Optional<T> update(@NonNull final ID id, @NonNull final S source, @NonNull final BiFunction<S, T, T> mapper) {
        Objects.requireNonNull(source, "The given source must not be null!");
        Objects.requireNonNull(mapper, "The given mapper must not be null!");
        return getToUpdateById(id).map(target -> mapper.apply(source, target));
    }

    @Transactional(readOnly = true)
    @NonNull
    Optional<T> getToDeleteById(@NonNull ID id);

    @Override
    default Optional<T> del(@NonNull final ID id) {
        return getToDeleteById(id).map(found -> {
            delete(found);
            return found;
        });
    }

    @Transactional(readOnly = true)
    @NonNull
    @Override
    T getById(ID id);

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e")
    @NonNull
    @Override
    List<T> getAll();

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e")
    @NonNull
    @Override
    Page<T> getAll(@NonNull Pageable pageable);

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e")
    @NonNull
    @Override
    List<T> getAll(@NonNull Sort sort);
}