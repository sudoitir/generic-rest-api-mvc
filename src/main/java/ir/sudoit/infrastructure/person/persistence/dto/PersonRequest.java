package ir.sudoit.infrastructure.person.persistence.dto;

import ir.sudoit.infrastructure.crud.persistence.dto.CrudRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PersonRequest  implements CrudRequest {

    private String name;

    private String mobile;

}