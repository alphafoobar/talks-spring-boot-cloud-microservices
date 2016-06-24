package com.frankmoley.service.controller;

import com.frankmoley.service.domain.Registration;
import com.frankmoley.service.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Registration> getForPerson(@RequestParam long personId) {
		return this.registrationService.getRegistrationsForPerson(personId);
	}
}
