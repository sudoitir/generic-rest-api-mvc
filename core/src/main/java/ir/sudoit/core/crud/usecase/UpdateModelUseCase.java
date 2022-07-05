package ir.sudoit.core.crud.usecase;


import ir.sudoit.core.crud.BaseModel;

public interface UpdateModelUseCase<T extends BaseModel> {
    void UpdateModelUseCase(T model);
}
