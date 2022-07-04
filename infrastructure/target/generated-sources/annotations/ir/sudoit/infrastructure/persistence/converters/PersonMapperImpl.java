package ir.sudoit.infrastructure.persistence.converters;

import ir.sudoit.core.person.PersonModel;
import ir.sudoit.infrastructure.persistence.entities.PersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-04T17:30:23+0430",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonModel toModel(PersonEntity person) {
        if ( person == null ) {
            return null;
        }

        PersonModel personModel = new PersonModel();

        personModel.setName( person.getName() );
        personModel.setMobile( person.getMobile() );
        personModel.setId( person.getId() );
        personModel.setCreatedDate( person.getCreatedDate() );
        personModel.setIsDeleted( person.getIsDeleted() );

        return personModel;
    }

    @Override
    public PersonEntity toEntity(PersonModel model) {
        if ( model == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setName( model.getName() );
        personEntity.setMobile( model.getMobile() );
        personEntity.setCreatedDate( model.getCreatedDate() );
        personEntity.setIsDeleted( model.getIsDeleted() );

        return personEntity;
    }

    @Override
    public List<PersonModel> toModel(List<PersonEntity> persons) {
        if ( persons == null ) {
            return null;
        }

        List<PersonModel> list = new ArrayList<PersonModel>( persons.size() );
        for ( PersonEntity personEntity : persons ) {
            list.add( toModel( personEntity ) );
        }

        return list;
    }

    @Override
    public List<PersonEntity> toEntity(List<PersonModel> models) {
        if ( models == null ) {
            return null;
        }

        List<PersonEntity> list = new ArrayList<PersonEntity>( models.size() );
        for ( PersonModel personModel : models ) {
            list.add( toEntity( personModel ) );
        }

        return list;
    }
}
