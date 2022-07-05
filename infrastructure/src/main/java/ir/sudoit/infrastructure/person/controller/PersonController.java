package ir.sudoit.infrastructure.person.controller;

import com.fasterxml.jackson.annotation.JsonView;
import ir.sudoit.infrastructure.crud.controller.AbstractCrudController;
import ir.sudoit.infrastructure.crud.controller.OnCreate;
import ir.sudoit.infrastructure.crud.controller.OnUpdate;
import ir.sudoit.infrastructure.crud.service.CrudService;
import ir.sudoit.infrastructure.person.persistence.dto.PersonRequest;
import ir.sudoit.infrastructure.person.persistence.dto.PersonResponse;
import ir.sudoit.infrastructure.person.persistence.dto.Views;
import ir.sudoit.infrastructure.person.persistence.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("people")
public class PersonController extends AbstractCrudController<PersonEntity, Long, PersonRequest, PersonResponse> {
    protected PersonController(CrudService<PersonEntity, Long, PersonRequest, PersonResponse> service) {
        super(service);
    }

    @JsonView(Views.ForPerson.class)
    @PostMapping
    @Override
    public ResponseEntity<PersonResponse> create(@Validated(OnCreate.class) @RequestBody @NonNull final PersonRequest request) {
        return super.create(request);
    }

    @JsonView(Views.ForPerson.class)
    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<PersonResponse> update(@PathVariable("id") @NonNull final Long id, @Validated(OnUpdate.class) @RequestBody @NonNull final PersonRequest request) {
        return super.update(id, request);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") @NonNull final Long id) {
        return super.delete(id);
    }

    @JsonView(Views.ForPerson.class)
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<PersonResponse> getOne(@PathVariable("id") @NonNull final Long id) {
        return super.getOne(id);
    }

    @JsonView(Views.ForPerson.class)
    @GetMapping
    @Override
    public ResponseEntity<Page<PersonResponse>> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }
}
