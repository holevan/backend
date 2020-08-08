package com.familyTree.hlv.service.mapper;

import com.familyTree.hlv.constant.enumeration.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@TestConfiguration
public class GenderMapperTest {

  private final GenderMapper mapper = new GenderMapper();

  @Test
  public void toOrdinalIsCorrect() {
    assertThat(mapper.toOrdinal(Gender.MALE)).isEqualTo(Gender.MALE.ordinal());
  }

  @Test
  public void toEnumIsCorrect() {
    assertThat(mapper.toGender(1)).isEqualTo(Gender.FEMALE);
  }
}
