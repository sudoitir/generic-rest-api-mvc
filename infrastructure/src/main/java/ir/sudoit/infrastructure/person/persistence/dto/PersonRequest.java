package ir.sudoit.infrastructure.person.persistence.dto;

import ir.sudoit.infrastructure.crud.controller.OnCreate;
import ir.sudoit.infrastructure.crud.persistence.dto.CrudRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PersonRequest implements CrudRequest {
    @NotBlank(groups = OnCreate.class)
    private String name;
}
