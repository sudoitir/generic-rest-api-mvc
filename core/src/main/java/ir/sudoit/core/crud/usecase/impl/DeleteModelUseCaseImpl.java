package ir.sudoit.core.crud.usecase.impl;


import ir.sudoit.core.crud.BaseModel;
import ir.sudoit.core.crud.ports.CrudRepositoryService;
import ir.sudoit.core.crud.usecase.DeleteModelUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteModelUseCaseImpl<T extends BaseModel> implements DeleteModelUseCase<T> {

    private final CrudRepositoryService<T> repositoryService;

    @Override
    public void DeleteModelUseCase(Long id) {
        repositoryService.deleteModel(id);
    }
}
