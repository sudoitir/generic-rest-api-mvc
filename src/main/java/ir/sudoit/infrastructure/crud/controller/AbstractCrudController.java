package ir.sudoit.infrastructure.crud.controller;

import ir.sudoit.infrastructure.crud.persistence.dto.CrudRequest;
import ir.sudoit.infrastructure.crud.persistence.dto.CrudResponse;
import ir.sudoit.infrastructure.crud.persistence.model.IdentifiableEntity;
import ir.sudoit.infrastructure.crud.service.CrudService;
import ir.sudoit.infrastructure.crud.utility.ApplicationUtilities;
import ir.sudoit.infrastructure.crud.utility.PropertiesConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractCrudController<T extends IdentifiableEntity<ID>, ID extends Serializable, Q extends CrudRequest, S extends CrudResponse> {

    protected final CrudService<T, ID, Q, S> service;

    protected final PropertiesConfig propertiesConfig;

    protected AbstractCrudController(@NonNull final CrudService<T, ID, Q, S> service, PropertiesConfig propertiesConfig) {
        this.service = service;
        this.propertiesConfig = propertiesConfig;
    }


    @NonNull
    public ResponseEntity<?> create(@NonNull final Q request) {
        S create = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApplicationUtilities.toActionResultWithObject(create, propertiesConfig));
    }

    @NonNull
    public ResponseEntity<?> create(@NonNull final T model) {
        T create = service.create(model);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApplicationUtilities.toActionResultWithObject(create, propertiesConfig));
    }


    @NonNull
    public ResponseEntity<?> update(@NonNull final Q request, @NonNull final ID id) {
        S update = service.update(id, request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApplicationUtilities.toActionResultWithObject(update, propertiesConfig));
    }

    @NonNull
    public ResponseEntity<?> update(@NonNull final T model, @NonNull final ID id) {
        T update = service.update(id, model);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApplicationUtilities.toActionResultWithObject(update, propertiesConfig));
    }


    @NonNull
    public ResponseEntity<?> delete(@NonNull final ID id) {
        if (service.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @NonNull
    public ResponseEntity<?> getOne(@NonNull final ID id) {
        S one = service.getOne(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ApplicationUtilities.toActionResultWithObject(one, propertiesConfig));
    }


    @NonNull
    public ResponseEntity<List<?>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}