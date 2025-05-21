package com.phase.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase.one.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>{
	
}
