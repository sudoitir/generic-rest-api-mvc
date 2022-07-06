package ir.sudoit.infrastructure.crud.service;

import ir.sudoit.infrastructure.crud.persistence.dto.CrudRequest;
import ir.sudoit.infrastructure.crud.persistence.dto.CrudResponse;
import ir.sudoit.infrastructure.crud.persistence.model.IdentifiableEntity;
import ir.sudoit.infrastructure.crud.persistence.model.EntityEvent;
import ir.sudoit.infrastructure.crud.persistence.mapper.CrudMapper;
import ir.sudoit.infrastructure.crud.persistence.repositories.CrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ir.sudoit.infrastructure.crud.utility.CrudUtils.copyNonNullProperties;

@Transactional
public abstract class AbstractCrudService<T extends IdentifiableEntity<ID>, ID extends Serializable, Q extends CrudRequest, S extends CrudResponse<ID>> implements CrudService<T, ID, Q, S> {

    protected final CrudRepo<T, ID> repo;
    protected final CrudMapper<T, ID, Q, S> mapper;

    @Autowired
    protected ApplicationEventPublisher publisher;

    protected AbstractCrudService(final CrudRepo<T, ID> repo, final CrudMapper<T, ID, Q, S> mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @NonNull
    @Override
    public T create(@NonNull final T source) {
        T entity = repo.create(source);

        EntityEvent<T, ID> event = onCreateEvent(entity);
        if (event != null) publisher.publishEvent(event);

        return entity;
    }

    @NonNull
    @Override
    public S create(@NonNull final Q source) {
        T entity = mapper.toCreate(source);
        onCreate(source, entity);
        repo.create(entity);

        EntityEvent<T, ID> event = onCreateEvent(entity);
        if (event != null) publisher.publishEvent(event);

        return mapper.toResponse(entity);
    }

    @NonNull
    @Override
    public Optional<T> update(final ID id, final T source) {
        return repo.update(id, source, (s, t) -> copyNonNullProperties(s, t, ignoredProps())).map(entity -> {
            EntityEvent<T, ID> event = onUpdateEvent(entity);
            if (event != null) publisher.publishEvent(event);
            return entity;
        });
    }

    @NonNull
    @Override
    public Optional<S> update(final ID id, final Q source) {
        return repo.update(id, source, new CallbackMapper<>(mapper::toUpdate, this::onUpdate)).map(entity -> {
            EntityEvent<T, ID> event = onUpdateEvent(entity);
            if (event != null) publisher.publishEvent(event);
            return mapper.toResponse(entity);
        });
    }

    @Override
    public boolean delete(@NonNull final ID id) {
        return repo.del(id).map(deleted -> {
            EntityEvent<T, ID> event = onDeleteEvent(deleted);
            if (event != null) publisher.publishEvent(event);
            return true;
        }).orElse(false);
    }

    @Transactional(readOnly = true)
    @NonNull
    @Override
    public Optional<T> getOneT(@NonNull final ID id) {
        return Optional.of(repo.getById(id));
    }

    @Transactional(readOnly = true)
    @NonNull
    @Override
    public Optional<S> getOne(@NonNull final ID id) {
        return getOneT(id).map(mapper::toResponse);
    }

    @Transactional(readOnly = true)
    @NonNull
    @Override
    public List<T> getAllT() {
        return repo.getAll();
    }

    @Transactional(readOnly = true)
    @NonNull
    @Override
    public List<S> getAll() {
        return repo.getAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @NonNull
    @Override
    public Page<T> getAllT(final Pageable pageable) {
        return repo.getAll(pageable);
    }

    @Transactional(readOnly = true)
    @NonNull
    @Override
    public Page<S> getAll(final Pageable pageable) {
//		return repo.getAll(pageable).map(mapper::toResponse); // works in SB 2.0+
        Page<T> page = repo.getAll(pageable);
        List<S> content = page.getContent().stream().map(mapper::toResponse).collect(Collectors.toList());
        return new PageImpl<>(content, pageable, page.getTotalElements());
    }

    @Transactional(readOnly = true)
    @NonNull
    @Override
    public List<T> getAllT(final Sort sort) {
        return repo.getAll(sort);
    }

    @Transactional(readOnly = true)
    @NonNull
    @Override
    public List<S> getAll(final Sort sort) {
        return repo.getAll(sort).stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    protected String[] ignoredProps() {
        return new String[]{"id", "version", "createdAt", "updatedAt"};
    }

    @NonNull
    protected void onCreate(@NonNull Q request, @NonNull T entity) {
    }

    @NonNull
    protected void onUpdate(@NonNull Q request, @NonNull T entity) {
    }

    protected EntityEvent<T, ID> onCreateEvent(@NonNull T entity) {
        return null;
    }

    protected EntityEvent<T, ID> onUpdateEvent(@NonNull T entity) {
        return null;
    }

    protected EntityEvent<T, ID> onDeleteEvent(@NonNull T entity) {
        return null;
    }
}