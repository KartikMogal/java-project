package com.phase.one.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phase.one.entity.Person;
import com.phase.one.exception.PersonNotFoundException;
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
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllPerson(){
		List<Person> persons = personServiceImpl.getAllPerson();
		if(persons.isEmpty()) {
			return new ResponseEntity<>("There is no person in database", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		Optional<Person> person = personServiceImpl.getById(id);
		if(!person.isPresent()) {
			throw new PersonNotFoundException("Person not found with id " + id);
		}
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
}
