package ir.sudoit.core.base.usecase.impl;


import ir.sudoit.core.base.BaseModel;
import ir.sudoit.core.base.ports.BaseRepositoryService;
import ir.sudoit.core.base.usecase.DeleteModelUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteModelUseCaseImpl<T extends BaseModel> implements DeleteModelUseCase<T> {

    private final BaseRepositoryService<T> repositoryService;

    @Override
    public void DeleteModelUseCase(Long id) {
        repositoryService.deleteModel(id);
    }
}
