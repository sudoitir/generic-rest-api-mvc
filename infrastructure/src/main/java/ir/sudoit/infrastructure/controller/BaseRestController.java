package ir.sudoit.infrastructure.controller;

import ir.sudoit.core.base.BaseModel;
import ir.sudoit.core.base.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseRestController<T extends BaseModel> {
    @Autowired
    private CreateModelUseCase<T> createModelUseCase;
    @Autowired
    private DeleteModelUseCase<T> deleteModelUseCase;
    @Autowired
    private GetModelListUseCase<T> getModelListUseCase;
    @Autowired
    private GetModelUseCase<T> getModelUseCase;
    @Autowired
    private UpdateModelUseCase<T> updateModelUseCase;

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T baseModel) {
        createModelUseCase.CreateModelUseCase(baseModel);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> delete(@PathVariable Long id) {
        deleteModelUseCase.DeleteModelUseCase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<List<T>> list(@PathVariable Long id) {
        List<T> models = getModelListUseCase.GetModelListUseCase(id);
        return ResponseEntity.ok(models);
    }

    @GetMapping("{id}")
    public ResponseEntity<T> get(@PathVariable Long id) {
        T model = getModelUseCase.GetModelUseCase(id);
        return ResponseEntity.ok(model);
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T baseModel) {
        updateModelUseCase.UpdateModelUseCase(baseModel);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
