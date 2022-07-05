package ir.sudoit.core.crud;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 6564057453123591118L;

    private Long id;

    @JsonIgnore
    private LocalDateTime createdDate;

    @JsonIgnore
    private LocalDateTime updateDateTime;

    private Boolean isDeleted;

}

