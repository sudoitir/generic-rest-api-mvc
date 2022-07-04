package ir.sudoit.infrastructure.persistence.entities;

import ir.sudoit.infrastructure.persistence.entities.base.BaseEntity;
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
public class PersonEntity extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = 3157238690846631805L;

    private String name;

    private String mobile;

}
