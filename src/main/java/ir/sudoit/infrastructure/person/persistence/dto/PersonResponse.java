package ir.sudoit.infrastructure.person.persistence.dto;

import com.fasterxml.jackson.annotation.JsonView;
import ir.sudoit.infrastructure.crud.persistence.dto.CrudResponse;
import ir.sudoit.infrastructure.crud.persistence.model.ContentAlias;
import lombok.Data;

@ContentAlias("people")
@Data
public class PersonResponse implements CrudResponse<Long> {
    @JsonView(Views.ForPerson.class)
    private Long id;
    @JsonView(Views.ForPerson.class)
    private String title;
}