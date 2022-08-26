package ir.sudoit.infrastructure.crud.persistence.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target (ElementType.TYPE)
@Retention (RetentionPolicy.RUNTIME)
public @interface ContentAlias
{
    /**
     * Defines the plural alias of the marked entity.
     *
     * @return the plural alias of the entity.
     */
    String value();
}