package ir.sudoit.infrastructure.person.persistence.dto;

import ir.sudoit.infrastructure.crud.persistence.dto.CrudResponse;
import lombok.*;

//@ContentAlias("people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PersonResponse implements CrudResponse{

    private Long id;

    private String name;
}