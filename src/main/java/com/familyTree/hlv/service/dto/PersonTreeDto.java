package com.familyTree.hlv.service.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonTreeDto {

  private Integer id;

  private String name;

  private int gender;

  private List<MarriageTreeDto> marriages;
}
