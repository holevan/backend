package com.familyTree.hlv.model.projection;

import com.familyTree.hlv.model.entity.Person;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "personInfoProjection", types = Person.class)
public interface PersonInfoProjection extends PersonSimplifiedInfoProjection {

  List<MarriageInfoProjection> getMarriages();
}
