package ir.sudoit.core.base.usecase.impl;


import ir.sudoit.core.base.BaseModel;
import ir.sudoit.core.base.ports.BaseRepositoryService;
import ir.sudoit.core.base.usecase.UpdateModelUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateModelUseCaseImpl<T extends BaseModel> implements UpdateModelUseCase<T> {

    private final BaseRepositoryService<T> repositoryService;

    @Override
    public void UpdateModelUseCase(T model) {
        repositoryService.updateModel(model);
    }

}
