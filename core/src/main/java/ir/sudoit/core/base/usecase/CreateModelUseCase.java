package ir.sudoit.core.base.usecase;


import ir.sudoit.core.base.BaseModel;

public interface CreateModelUseCase<T extends BaseModel> {

    void CreateModelUseCase(T model);
}
