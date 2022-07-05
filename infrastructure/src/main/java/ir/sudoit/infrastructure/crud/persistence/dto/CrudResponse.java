package ir.sudoit.infrastructure.crud.persistence.dto;

import org.springframework.lang.NonNull;

import java.io.Serializable;

public interface CrudResponse <ID extends Serializable> extends Serializable{
    @NonNull
    ID getId();
}
