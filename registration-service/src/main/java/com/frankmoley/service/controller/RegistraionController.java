package com.frankmoley.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frankmoley.service.domain.Registration;
import com.frankmoley.service.service.RegistrationService;

@RestController
@RequestMapping("/registrations")
public class RegistraionController {
	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Registration> getRegistrations(@RequestParam("personId") Long personId) {
		return this.registrationService.getRegistrationsForPerson(personId);
	}

	// @RequestMapping(method = RequestMethod.POST)
}
