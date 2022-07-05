package ir.sudoit.core.crud.usecase.impl;


import ir.sudoit.core.crud.BaseModel;
import ir.sudoit.core.crud.ports.CrudRepositoryService;
import ir.sudoit.core.crud.usecase.GetModelUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetModelUseCaseImpl<T extends BaseModel> implements GetModelUseCase<T> {

    private final CrudRepositoryService<T> repositoryService;

    @Override
    public T GetModelUseCase(Long id) {
        return repositoryService.getModel(id);
    }

}
