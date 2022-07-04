package ir.sudoit.core.base.ports;

import ir.sudoit.core.base.BaseModel;

import java.util.List;

public interface BaseRepositoryService<T extends BaseModel> {

    List<T> listModel(Long id);

    void createModel(T model);

    void updateModel(T model);

    void deleteModel(Long id);

    T getModel(Long id);

    boolean isModelExist(Long id);
}
