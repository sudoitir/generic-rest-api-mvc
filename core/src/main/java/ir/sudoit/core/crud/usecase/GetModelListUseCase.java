package ir.sudoit.core.crud.usecase;



import ir.sudoit.core.crud.BaseModel;

import java.util.List;

public interface GetModelListUseCase<T extends BaseModel> {
    List<T> GetModelListUseCase(Long id);
}
