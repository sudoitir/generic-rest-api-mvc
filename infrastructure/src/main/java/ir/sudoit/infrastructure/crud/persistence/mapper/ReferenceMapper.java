package ir.sudoit.infrastructure.crud.persistence.mapper;

import ir.sudoit.infrastructure.crud.persistence.model.IdentifiableEntity;
import ir.sudoit.infrastructure.crud.persistence.repositories.BaseRepo;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@FunctionalInterface
public interface ReferenceMapper<T extends IdentifiableEntity<ID>, ID extends Serializable> {

    @NonNull
    BaseRepo<T, ID> getRepo();


    @NonNull
    default T toReference(@NonNull ID id) {
        Objects.requireNonNull(id, "The id must not be null!");
        return getRepo().getOne(id);
    }

    @NonNull
    default ID toId(@NonNull T entity) {
        Objects.requireNonNull(entity, "The entity must not be null!");
        return Objects.requireNonNull(entity.getId(), "The entity id must not be null!");
    }

    @NonNull
    default Set<T> toRefSet(@NonNull Collection<ID> ids) {
        Objects.requireNonNull(ids, "The 'ids' must not be null!");
        return ids.stream().map(this::toReference).collect(toSet());
    }

    @NonNull
    default Set<ID> toIdSet(@NonNull Collection<T> entities) {
        Objects.requireNonNull(entities, "The entities must not be null!");
        return entities.stream().map(this::toId).filter(Objects::nonNull).collect(toSet());
    }


    @NonNull
    default List<T> toRefList(@NonNull Collection<ID> ids) {
        Objects.requireNonNull(ids, "The 'ids' must not be null!");
        return ids.stream().map(this::toReference).collect(toList());
    }

    @NonNull
    default List<ID> toIdList(@NonNull Collection<T> entities) {
        Objects.requireNonNull(entities, "The entities must not be null!");
        return entities.stream().map(this::toId).filter(Objects::nonNull).collect(toList());
    }
}