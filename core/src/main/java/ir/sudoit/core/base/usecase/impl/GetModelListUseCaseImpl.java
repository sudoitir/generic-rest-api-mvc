package ir.sudoit.core.base.usecase.impl;


import ir.sudoit.core.base.BaseModel;
import ir.sudoit.core.base.ports.BaseRepositoryService;
import ir.sudoit.core.base.usecase.GetModelListUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetModelListUseCaseImpl<T extends BaseModel> implements GetModelListUseCase<T> {

    private final BaseRepositoryService<T> repositoryService;

    @Override
    public List<T> GetModelListUseCase(Long id) {
        return repositoryService.listModel(id);

    }
}
