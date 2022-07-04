package ir.sudoit.infrastructure.persistence.impl.base;

import ir.sudoit.core.base.BaseModel;
import ir.sudoit.core.base.ports.BaseRepositoryService;
import ir.sudoit.infrastructure.persistence.entities.base.BaseEntity;

import java.util.List;

public class BaseServiceImpl<T extends BaseEntity<Long>, K extends BaseModel> implements BaseRepositoryService<K> {
    @Override
    public List<K> listModel(Long id) {
        return null;
    }

    @Override
    public void createModel(K model) {

    }

    @Override
    public void updateModel(K model) {

    }

    @Override
    public void deleteModel(Long id) {

    }

    @Override
    public K getModel(Long id) {
        return null;
    }

    @Override
    public boolean isModelExist(Long id) {
        return false;
    }
}
