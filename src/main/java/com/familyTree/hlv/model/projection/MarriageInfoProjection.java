package com.familyTree.hlv.model.projection;

import com.familyTree.hlv.model.entity.Marriage;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "marriageInfoProjection", types = Marriage.class)
public interface MarriageInfoProjection {

  PersonSimplifiedInfoProjection getSpouse();

  Integer getIndex();

  List<PersonSimplifiedInfoProjection> getChildren();
}
