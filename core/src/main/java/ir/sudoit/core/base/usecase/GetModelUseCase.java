package ir.sudoit.core.base.usecase;


import ir.sudoit.core.base.BaseModel;

public interface GetModelUseCase<T extends BaseModel> {
    T GetModelUseCase(Long id);
}
