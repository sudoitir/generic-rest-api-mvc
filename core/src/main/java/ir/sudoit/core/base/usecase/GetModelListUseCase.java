package ir.sudoit.core.base.usecase;



import ir.sudoit.core.base.BaseModel;

import java.util.List;

public interface GetModelListUseCase<T extends BaseModel> {
    List<T> GetModelListUseCase(Long id);
}
