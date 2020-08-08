package com.familyTree.hlv.service.mapper;

import com.familyTree.hlv.model.entity.Marriage;
import com.familyTree.hlv.service.dto.MarriageTreeDto;
import com.familyTree.hlv.service.dto.MarriageTreeDto.MarriageTreeDtoBuilder;
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
public class MarriageMapperImpl implements MarriageMapper {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public MarriageTreeDto toMarriageTreeDto(Marriage marriage) {
        if ( marriage == null ) {
            return null;
        }

        MarriageTreeDtoBuilder marriageTreeDto = MarriageTreeDto.builder();

        marriageTreeDto.pid( marriage.getPid() );
        marriageTreeDto.spouse( personMapper.toPersonTreeDto( marriage.getSpouse() ) );
        marriageTreeDto.children( personMapper.toPersonTreeDtos( marriage.getChildren() ) );

        return marriageTreeDto.build();
    }

    @Override
    public List<MarriageTreeDto> toMarriageTreeDtos(List<Marriage> marriage) {
        if ( marriage == null ) {
            return null;
        }

        List<MarriageTreeDto> list = new ArrayList<MarriageTreeDto>( marriage.size() );
        for ( Marriage marriage1 : marriage ) {
            list.add( toMarriageTreeDto( marriage1 ) );
        }

        return list;
    }
}
