package com.familyTree.hlv.service.mapper;

import com.familyTree.hlv.model.entity.Person;
import com.familyTree.hlv.service.dto.PersonTreeDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestConfiguration
@ExtendWith(MockitoExtension.class)
public class PersonMapperTest {

  private final PersonMapper mapper = Mockito.mock(PersonMapper.class);

  private final PersonTreeDto dto = PersonTreeDto.builder().id(1).name("Le Van A").build();
  private final Person person = Person.builder().id(1).name("Le Van A").build();

  @Test
  public void toDtoIsCorrect() {
    when(mapper.toPersonTreeDto(any(Person.class))).thenReturn(dto);
    PersonTreeDto mappedDto = mapper.toPersonTreeDto(person);
    assertThat(mappedDto.getId()).isEqualTo(dto.getId());
  }
}
