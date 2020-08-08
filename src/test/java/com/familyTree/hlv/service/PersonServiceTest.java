package com.familyTree.hlv.service;


import com.familyTree.hlv.model.entity.Marriage;
import com.familyTree.hlv.model.entity.Person;
import com.familyTree.hlv.repository.PersonRepository;
import com.familyTree.hlv.service.dto.MarriageTreeDto;
import com.familyTree.hlv.service.dto.PersonTreeDto;
import com.familyTree.hlv.service.mapper.PersonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@TestConfiguration
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  private final PersonRepository personRepository = Mockito.mock(PersonRepository.class);
  private final PersonMapper personMapper = Mockito.mock(PersonMapper.class);
  private PersonService personService;

  @BeforeEach
  void init() {
    this.personService = new PersonService(personRepository, personMapper);
  }

  private final PersonTreeDto childDto = PersonTreeDto.builder().id(3).name("Le Thi C").build();
  private final Person child = Person.builder().id(3).name("Le Thi C").build();
  private final PersonTreeDto spouseDto = PersonTreeDto.builder().id(2).name("Nguyen Thi B").build();
  private final Person spouse = Person.builder().id(2).name("Nguyen Thi B").build();
  private final MarriageTreeDto marriageDto = MarriageTreeDto.builder().pid(1).spouse(spouseDto)
      .children(Collections.singletonList(childDto)).build();
  private final Marriage marriage = Marriage.builder().pid(1).spouse(spouse)
      .children(Collections.singletonList(child)).build();
  private final PersonTreeDto dto = PersonTreeDto.builder().id(1).name("Le Van A")
      .marriages(Collections.singletonList(marriageDto)).build();
  private final Person person = Person.builder().id(1).name("Le Van A")
      .marriages(Collections.singletonList(marriage)).build();

  @Test
  public void saveIsCorrect() {
    when(personService.save(any(Person.class))).thenReturn(dto);
    PersonTreeDto savedPerson = personService.save(person);
    assertThat(savedPerson).isNotNull();
    assertThat(savedPerson.getId()).isEqualTo(dto.getId());
    assertThat(savedPerson.getName()).isEqualTo(dto.getName());
    MarriageTreeDto savedMarriage = savedPerson.getMarriages().get(0);
    MarriageTreeDto marriageDto = dto.getMarriages().get(0);
    assertThat(savedMarriage).isNotNull();
    assertThat(savedMarriage.getPid()).isEqualTo(marriageDto.getPid());
    assertThat(savedMarriage.getSpouse()).isEqualTo(marriageDto.getSpouse());
    assertThat(savedMarriage.getChildren().get(0)).isEqualTo(marriageDto.getChildren().get(0));
  }

  @Test
  public void getIsCorrect() {
    when(personService.getById(anyInt())).thenReturn(dto);
    PersonTreeDto savedPerson = personService.save(person);
    assertThat(savedPerson).isNotNull();
  }
}