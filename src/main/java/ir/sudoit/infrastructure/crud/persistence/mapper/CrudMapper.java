package ir.sudoit.infrastructure.crud.persistence.mapper;

import ir.sudoit.infrastructure.crud.persistence.dto.CrudRequest;
import ir.sudoit.infrastructure.crud.persistence.dto.CrudResponse;
import ir.sudoit.infrastructure.crud.persistence.model.IdentifiableEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.lang.NonNull;

import java.io.Serializable;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@MapperConfig(
        nullValueMappingStrategy = RETURN_DEFAULT,
        nullValueCheckStrategy = ALWAYS,
        nullValuePropertyMappingStrategy = IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface CrudMapper<T extends IdentifiableEntity<ID>, ID extends Serializable, Q extends CrudRequest, S extends CrudResponse> {

    /**
     * Maps an input (request) DTO to the related entity to be created.
     *
     * @param request input (request) DTO, must not be {@code null}
     * @return related entity, never be {@code null}
     */
    @NonNull
    T toCreate(@NonNull Q request);

    /**
     * Maps an input (request) DTO to the related entity to be updated.
     *
     * @param request input (request) DTO, must not be {@code null}
     * @param target  updated entity, must not be {@code null}
     * @return updated entity, never be {@code null}
     */
    @NonNull
    T toUpdate(@NonNull Q request, @MappingTarget @NonNull T target);

    /**
     * Maps an entity to the related output (response) DTO.
     *
     * @param entity must not be {@code null}
     * @return output (response) DTO, never be {@code null}
     */
    @NonNull
    S toResponse(@NonNull T entity);
}