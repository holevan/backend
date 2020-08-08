package com.familyTree.hlv.service.mapper;

import com.familyTree.hlv.service.dto.MarriageTreeDto;
import com.familyTree.hlv.model.entity.Marriage;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, GenderMapper.class})
public interface MarriageMapper {

  MarriageTreeDto toMarriageTreeDto(Marriage marriage);

  List<MarriageTreeDto> toMarriageTreeDtos(List<Marriage> marriage);

//  Marriage toEntity(MarriageTreeDto marriageTreeDto);
//
//  List<Marriage> toEntities(List<MarriageTreeDto> marriageTreeDtos);
}
