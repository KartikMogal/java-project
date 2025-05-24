package com.phase.one.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase.one.entity.Person;
import com.phase.one.exception.EmptyInputException;
import com.phase.one.repository.PersonRepo;
import com.phase.one.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	private final PersonRepo personRepo;
	
	@Autowired
	public PersonServiceImpl(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}

	@Override
	public Person savePerson(Person person) {
		if(person.getName().isEmpty() || person.getName().trim().isEmpty()) {
			throw new EmptyInputException("Input fields are empty");
		}
		return personRepo.save(person);
	} 
	
}
