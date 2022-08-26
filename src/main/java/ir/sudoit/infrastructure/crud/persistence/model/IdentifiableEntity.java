package ir.sudoit.infrastructure.crud.persistence.model;


import java.io.Serializable;


public interface IdentifiableEntity<ID extends Serializable> extends Serializable
{

    ID getId();
}
