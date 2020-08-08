package com.familyTree.hlv.repository;

import com.familyTree.hlv.model.projection.MarriageInfoProjection;
import com.familyTree.hlv.model.entity.Marriage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = MarriageInfoProjection.class)
public interface MarriageRepository extends JpaRepository<Marriage, Integer> {

}
