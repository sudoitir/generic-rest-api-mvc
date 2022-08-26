package ir.sudoit.infrastructure.crud.service;

import ir.sudoit.infrastructure.crud.persistence.dto.CrudRequest;
import ir.sudoit.infrastructure.crud.persistence.dto.CrudResponse;
import ir.sudoit.infrastructure.crud.persistence.model.IdentifiableEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudService<T extends IdentifiableEntity<ID>, ID extends Serializable, Q extends CrudRequest, S extends CrudResponse>
{

    S create(Q source);


    T create(T source);


    S update(ID id, Q source);


    T update(ID id, T source);


    boolean delete(ID id);


    S getOne(ID id);


    Optional<T> getOneT(ID id);


    List<S> getAll();


    List<T> getAllT();
}
