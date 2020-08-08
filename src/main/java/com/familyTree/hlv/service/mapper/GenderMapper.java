package com.familyTree.hlv.service.mapper;

import com.familyTree.hlv.constant.enumeration.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class GenderMapper {

  public Gender toGender(int ordinal) {
    return Gender.values()[ordinal];
  }

  public int toOrdinal(Gender gender) {
    return gender.ordinal();
  }
}
