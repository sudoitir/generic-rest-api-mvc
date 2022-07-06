package ir.sudoit.infrastructure.crud.controller;

import ir.sudoit.infrastructure.crud.persistence.dto.CrudRequest;
import ir.sudoit.infrastructure.crud.persistence.dto.CrudResponse;
import ir.sudoit.infrastructure.crud.persistence.model.IdentifiableEntity;
import ir.sudoit.infrastructure.crud.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractCrudController<T extends IdentifiableEntity<ID>, ID extends Serializable, Q extends CrudRequest, S extends CrudResponse<ID>> {

    protected final CrudService<T, ID, Q, S> service;

    protected AbstractCrudController(@NonNull final CrudService<T, ID, Q, S> service) {
        this.service = service;
    }


    @NonNull
    public ResponseEntity<S> create(@NonNull final Q request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }


    @NonNull
    public ResponseEntity<S> update(@NonNull final ID id, @NonNull final Q request) {
        return service.update(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @NonNull
    public ResponseEntity<?> delete(@NonNull final ID id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @NonNull
    public ResponseEntity<S> getOne(@NonNull final ID id) {
        return service.getOne(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @NonNull
    public ResponseEntity<Page<S>> getAll(@NonNull final Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }


    @NonNull
    public ResponseEntity<List<S>> getAll(@NonNull final Sort sort) {
        return ResponseEntity.ok(service.getAll(sort));
    }


    @NonNull
    public ResponseEntity<List<S>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}