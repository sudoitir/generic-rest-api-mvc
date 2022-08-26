package ir.sudoit.infrastructure.crud.persistence.repositories;

import ir.sudoit.infrastructure.crud.persistence.model.IdentifiableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public interface CrudRepo<T extends IdentifiableEntity<ID>, ID extends Serializable>
{

    @NonNull
    T create(@NonNull T entity);

    @NonNull
    <S> Optional<T> update(@NonNull ID id, @NonNull S source, @NonNull BiFunction<S, T, T> mapper);


    @NonNull
    Optional<T> del(@NonNull ID id);


    @NonNull
    T getById(@NonNull ID id);


    @NonNull
    List<T> getAll();


    @NonNull
    Page<T> getAll(@NonNull Pageable pageable);


    @NonNull
    List<T> getAll(@NonNull Sort sort);
}