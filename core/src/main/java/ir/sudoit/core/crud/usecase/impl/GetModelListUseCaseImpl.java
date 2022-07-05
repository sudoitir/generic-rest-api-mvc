package ir.sudoit.core.crud.usecase.impl;


import ir.sudoit.core.crud.BaseModel;
import ir.sudoit.core.crud.ports.CrudRepositoryService;
import ir.sudoit.core.crud.usecase.GetModelListUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetModelListUseCaseImpl<T extends BaseModel> implements GetModelListUseCase<T> {

    private final CrudRepositoryService<T> repositoryService;

    @Override
    public List<T> GetModelListUseCase(Long id) {
        return repositoryService.listModel(id);

    }
}
