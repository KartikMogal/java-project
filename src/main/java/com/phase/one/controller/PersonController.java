package com.phase.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phase.one.entity.Person;
import com.phase.one.serviceImpl.PersonServiceImpl;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	private final PersonServiceImpl personServiceImpl;
	
	@Autowired
	public PersonController(PersonServiceImpl personServiceImpl) {
		this.personServiceImpl = personServiceImpl;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Person> savePerson(@RequestBody Person person) {
		Person savedPerson = personServiceImpl.savePerson(person);
		return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
	}
	
}
