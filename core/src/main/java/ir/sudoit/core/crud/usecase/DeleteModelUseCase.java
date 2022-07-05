package ir.sudoit.core.crud.usecase;


import ir.sudoit.core.crud.BaseModel;

public interface DeleteModelUseCase<T extends BaseModel> {
    void DeleteModelUseCase(Long id);
}
