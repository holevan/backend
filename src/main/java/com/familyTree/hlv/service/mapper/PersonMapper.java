package com.familyTree.hlv.service.mapper;

import com.familyTree.hlv.service.dto.PersonTreeDto;
import com.familyTree.hlv.model.entity.Person;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MarriageMapper.class, GenderMapper.class})
public interface PersonMapper {

  PersonTreeDto toPersonTreeDto(Person person);

  List<PersonTreeDto> toPersonTreeDtos(List<Person> people);

//  Person toEntity(PersonTreeDto personTreeDto);
//
//  List<Person> toEntities(List<PersonTreeDto> personTreeDtos);
}
