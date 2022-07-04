package ir.sudoit.core.base.usecase;


import ir.sudoit.core.base.BaseModel;

public interface UpdateModelUseCase<T extends BaseModel> {
    void UpdateModelUseCase(T model);
}
