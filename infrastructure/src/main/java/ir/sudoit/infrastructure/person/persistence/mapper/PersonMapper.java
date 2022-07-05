package ir.sudoit.infrastructure.person.persistence.mapper;

import ir.sudoit.core.person.PersonModel;
import ir.sudoit.infrastructure.crud.persistence.mapper.CrudMapper;
import ir.sudoit.infrastructure.crud.persistence.mapper.ReferenceMapper;
import ir.sudoit.infrastructure.person.persistence.dto.PersonRequest;
import ir.sudoit.infrastructure.person.persistence.dto.PersonResponse;
import ir.sudoit.infrastructure.person.persistence.entity.PersonEntity;
import ir.sudoit.infrastructure.person.persistence.repository.PersonJpaRepository;
import lombok.Getter;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Mapper(config = CrudMapper.class)
@Component
public abstract class PersonMapper implements CrudMapper<PersonEntity,Long, PersonRequest, PersonResponse>, ReferenceMapper<PersonEntity, Long> {
    @Autowired
    @Getter
    private PersonJpaRepository repo;
}