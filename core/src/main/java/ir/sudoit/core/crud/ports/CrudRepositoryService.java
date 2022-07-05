package ir.sudoit.core.crud.ports;

import ir.sudoit.core.crud.BaseModel;

import java.util.List;

public interface CrudRepositoryService<T extends BaseModel> {

    List<T> listModel(Long id);

    void createModel(T model);

    void updateModel(T model);

    void deleteModel(Long id);

    T getModel(Long id);

    boolean isModelExist(Long id);
}
