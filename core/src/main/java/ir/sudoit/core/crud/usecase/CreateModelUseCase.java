package ir.sudoit.core.crud.usecase;


import ir.sudoit.core.crud.BaseModel;

public interface CreateModelUseCase<T extends BaseModel> {

    void CreateModelUseCase(T model);
}
