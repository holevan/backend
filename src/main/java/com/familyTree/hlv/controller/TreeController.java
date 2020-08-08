package com.familyTree.hlv.controller;

import com.familyTree.hlv.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreeController {

  private final PersonService personService;

  public TreeController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping(value = "/api/tree")
  public ResponseEntity<?> tree() {
    return ResponseEntity.ok().body(personService.getById(1));
  }
}
