package com.familyTree.hlv.service.mapper;

import com.familyTree.hlv.model.entity.Person;
import com.familyTree.hlv.service.dto.PersonTreeDto;
import com.familyTree.hlv.service.dto.PersonTreeDto.PersonTreeDtoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-08T11:11:46+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Autowired
    private MarriageMapper marriageMapper;
    @Autowired
    private GenderMapper genderMapper;

    @Override
    public PersonTreeDto toPersonTreeDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonTreeDtoBuilder personTreeDto = PersonTreeDto.builder();

        personTreeDto.id( person.getId() );
        personTreeDto.name( person.getName() );
        personTreeDto.gender( genderMapper.toOrdinal( person.getGender() ) );
        personTreeDto.marriages( marriageMapper.toMarriageTreeDtos( person.getMarriages() ) );

        return personTreeDto.build();
    }

    @Override
    public List<PersonTreeDto> toPersonTreeDtos(List<Person> people) {
        if ( people == null ) {
            return null;
        }

        List<PersonTreeDto> list = new ArrayList<PersonTreeDto>( people.size() );
        for ( Person person : people ) {
            list.add( toPersonTreeDto( person ) );
        }

        return list;
    }
}
