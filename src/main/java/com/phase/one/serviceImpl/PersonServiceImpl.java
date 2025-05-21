package com.phase.one.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase.one.entity.Person;
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
		return personRepo.save(person);
	} 
	
}
