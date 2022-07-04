package ir.sudoit.core.base.usecase;


import ir.sudoit.core.base.BaseModel;

public interface DeleteModelUseCase<T extends BaseModel> {
    void DeleteModelUseCase(Long id);
}
