package ir.sudoit.infrastructure.person.service;

import ir.sudoit.infrastructure.crud.service.AbstractCrudService;
import ir.sudoit.infrastructure.person.persistence.dto.PersonRequest;
import ir.sudoit.infrastructure.person.persistence.dto.PersonResponse;
import ir.sudoit.infrastructure.person.persistence.entity.PersonEntity;
import ir.sudoit.infrastructure.person.persistence.mapper.PersonMapper;
import ir.sudoit.infrastructure.person.persistence.repository.PersonJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends AbstractCrudService<PersonEntity,Long, PersonRequest, PersonResponse> {
    public PersonServiceImpl(final PersonJpaRepository repo, final PersonMapper mapper) {
        super(repo, mapper);
    }
}
