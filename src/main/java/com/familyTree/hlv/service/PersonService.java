package com.familyTree.hlv.service;

import com.familyTree.hlv.model.entity.Person;
import com.familyTree.hlv.service.dto.PersonTreeDto;
import com.familyTree.hlv.service.mapper.PersonMapper;
import com.familyTree.hlv.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonRepository repository;
  private final PersonMapper personMapper;

  public PersonService(PersonRepository repository,
                       PersonMapper personMapper) {
    this.repository = repository;
    this.personMapper = personMapper;
  }

  public PersonTreeDto getById(Integer id) {
    return personMapper.toPersonTreeDto(repository.getOne(id));
  }

  public PersonTreeDto save(Person person) {
    return personMapper.toPersonTreeDto(repository.save(person));
  }
}