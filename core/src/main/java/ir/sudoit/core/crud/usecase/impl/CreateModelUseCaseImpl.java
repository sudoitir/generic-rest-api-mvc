package ir.sudoit.core.crud.usecase.impl;


import ir.sudoit.core.crud.BaseModel;
import ir.sudoit.core.crud.ports.CrudRepositoryService;
import ir.sudoit.core.crud.usecase.CreateModelUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateModelUseCaseImpl<T extends BaseModel> implements CreateModelUseCase<T> {

    private final CrudRepositoryService<T> repositoryService;

    @Override
    public void CreateModelUseCase(T model) {
        repositoryService.createModel(model);
    }
}
