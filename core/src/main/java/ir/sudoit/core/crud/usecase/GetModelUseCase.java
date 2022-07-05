package ir.sudoit.core.crud.usecase;


import ir.sudoit.core.crud.BaseModel;

public interface GetModelUseCase<T extends BaseModel> {
    T GetModelUseCase(Long id);
}
