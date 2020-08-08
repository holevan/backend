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
public class MarriageTreeDto {

  private Integer pid;

  private PersonTreeDto spouse;

  private List<PersonTreeDto> children;
}
