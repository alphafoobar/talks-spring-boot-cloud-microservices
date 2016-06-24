package com.frankmoley.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frankmoley.service.entity.Person;
import com.frankmoley.service.repository.PersonRepository;

@RestController
@RequestMapping(value = "/people")
public class PersonController {
	private PersonRepository personRepository;

	@Autowired
	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Person> getAll() {
		return this.personRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Person createPerson(@RequestBody Person person) {
		return this.personRepository.save(person);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable long id) {
		return this.personRepository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Person updatePerson(@PathVariable long id, @RequestBody Person person) {
		person.setId(id);
		return this.personRepository.save(person);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		this.personRepository.delete(id);
	}
}
