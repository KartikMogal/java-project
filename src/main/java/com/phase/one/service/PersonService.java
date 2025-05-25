package com.phase.one.service;

import java.util.List;
import java.util.Optional;

import com.phase.one.entity.Person;

public interface PersonService {
	
	Person savePerson(Person person);
	List<Person> getAllPerson();
	Optional<Person> getById(int id);
}
