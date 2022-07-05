package ir.sudoit.core.crud.usecase.impl;


import ir.sudoit.core.crud.BaseModel;
import ir.sudoit.core.crud.ports.CrudRepositoryService;
import ir.sudoit.core.crud.usecase.UpdateModelUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateModelUseCaseImpl<T extends BaseModel> implements UpdateModelUseCase<T> {

    private final CrudRepositoryService<T> repositoryService;

    @Override
    public void UpdateModelUseCase(T model) {
        repositoryService.updateModel(model);
    }

}
