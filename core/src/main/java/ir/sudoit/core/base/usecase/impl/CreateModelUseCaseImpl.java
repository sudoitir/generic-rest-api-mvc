package ir.sudoit.core.base.usecase.impl;


import ir.sudoit.core.base.BaseModel;
import ir.sudoit.core.base.ports.BaseRepositoryService;
import ir.sudoit.core.base.usecase.CreateModelUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateModelUseCaseImpl<T extends BaseModel> implements CreateModelUseCase<T> {

    private final BaseRepositoryService<T> repositoryService;

    @Override
    public void CreateModelUseCase(T model) {
        repositoryService.createModel(model);
    }
}
