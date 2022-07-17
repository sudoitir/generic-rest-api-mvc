package ir.sudoit.infrastructure.crud.utility;

import ir.sudoit.infrastructure.crud.persistence.model.MetaModel;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ActionResult<T> {

    private MetaModel meta;
    private T data;

    public ActionResult(MetaModel meta, T data) {
        this.meta = meta;
        this.data = data;
    }


    public ActionResult(MetaModel meta) {
        this.meta = meta;
    }
}