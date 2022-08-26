package ir.sudoit.infrastructure.person.controller;

import ir.sudoit.infrastructure.crud.controller.AbstractCrudController;
import ir.sudoit.infrastructure.crud.service.CrudService;
import ir.sudoit.infrastructure.crud.utility.PropertiesConfig;
import ir.sudoit.infrastructure.person.persistence.dto.PersonRequest;
import ir.sudoit.infrastructure.person.persistence.dto.PersonResponse;
import ir.sudoit.infrastructure.person.persistence.entity.PersonEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

/**
 * @apiNote The controller can have any method of CRUD you want by overriding it
 * @see ir.sudoit.infrastructure.crud.controller.AbstractCrudController
 */
@RestController
@RequestMapping ("people")
public class PersonController extends AbstractCrudController<PersonEntity, Long, PersonRequest, PersonResponse>
{

    private final PropertiesConfig propertiesConfig;

    protected PersonController(CrudService<PersonEntity, Long, PersonRequest, PersonResponse> service,
                               PropertiesConfig propertiesConfig)
    {
        super(service, propertiesConfig);
        this.propertiesConfig = propertiesConfig;
    }


    @PostMapping
    @Override
    @NonNull
    public ResponseEntity<?> create(@RequestBody @NonNull final PersonRequest request)
    {
        return super.create(request);
    }

    @PatchMapping ("{id}")
    @Override
    @NonNull
    public ResponseEntity<?> update(@RequestBody @NonNull final PersonRequest request,
                                    @PathVariable ("id") @NonNull final Long id)
    {
        return super.update(request, id);
    }

    @DeleteMapping ("{id}")
    @Override
    @NonNull
    public ResponseEntity<?> delete(@PathVariable ("id") @NonNull final Long id)
    {
        return super.delete(id);
    }

    @GetMapping ("{id}")
    @Override
    @NonNull
    public ResponseEntity<?> getOne(@PathVariable ("id") @NonNull final Long id)
    {
        return super.getOne(id);
    }
}
