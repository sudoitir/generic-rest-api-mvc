package ir.sudoit.infrastructure.person.persistence.entity;

import ir.sudoit.infrastructure.crud.persistence.model.LongIdEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonEntity extends LongIdEntity {

    @Serial
    private static final long serialVersionUID = 3157238690846631805L;

    private String name;

    private String mobile;

}
