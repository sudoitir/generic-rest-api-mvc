package ir.sudoit.core.base.usecase.impl;


import ir.sudoit.core.base.BaseModel;
import ir.sudoit.core.base.ports.BaseRepositoryService;
import ir.sudoit.core.base.usecase.GetModelUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetModelUseCaseImpl<T extends BaseModel> implements GetModelUseCase<T> {

    private final BaseRepositoryService<T> repositoryService;

    @Override
    public T GetModelUseCase(Long id) {
        return repositoryService.getModel(id);
    }

}
