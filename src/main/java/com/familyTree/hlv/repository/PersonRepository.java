package com.familyTree.hlv.repository;

import com.familyTree.hlv.model.projection.PersonInfoProjection;
import com.familyTree.hlv.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = PersonInfoProjection.class)
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
