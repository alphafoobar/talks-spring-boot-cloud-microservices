package com.frankmoley.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frankmoley.service.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	Person findByEmailAddress(String emailAddress);
}
