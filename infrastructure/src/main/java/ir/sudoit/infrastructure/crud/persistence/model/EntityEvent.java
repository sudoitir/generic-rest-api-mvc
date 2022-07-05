package ir.sudoit.infrastructure.crud.persistence.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public record EntityEvent<T extends IdentifiableEntity<ID>, ID extends Serializable>(T entity) implements Serializable {


    @Serial
    private static final long serialVersionUID = 62148992991160489L;

    public EntityEvent(final T entity) {
        this.entity = Objects.requireNonNull(entity, "Parameter 'entity' must not be null!");
    }


    public boolean contain(String simpleClassName) {
        return Objects.requireNonNull(entity, "Parameter 'simpleClassName' must not be null!")
                .getClass()
                .getSimpleName()
                .equals(simpleClassName);
    }
}