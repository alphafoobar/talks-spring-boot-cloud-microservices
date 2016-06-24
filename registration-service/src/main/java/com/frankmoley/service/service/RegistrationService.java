package com.frankmoley.service.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.frankmoley.service.domain.Appointment;
import com.frankmoley.service.domain.Person;
import com.frankmoley.service.domain.Registration;

@Service
public class RegistrationService {

	@Autowired
	private DiscoveryClient discoveryClient;
	private static final String PERSON_SERVICE = "PERSON-SERVICE";
	private static final String APPOINTMENT_SERVICE = "APPOINTMENT-SERVICE";

	private RestTemplate restTemplate = new RestTemplate();
	private static HttpEntity<String> httpEntity;

	static {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		httpEntity = new HttpEntity(headers);
	}

	public List<Registration> getRegistrationsForPerson(long personId) {
		URI personService = this.discoveryClient.getInstances(PERSON_SERVICE).get(0).getUri();
		personService = URI.create(personService.toString() + "/people/" + personId);
		Person person = this.restTemplate.exchange(personService, HttpMethod.GET, httpEntity, Person.class).getBody();
		URI appointmentService = this.discoveryClient.getInstances(APPOINTMENT_SERVICE).get(0).getUri();
		appointmentService = URI.create(appointmentService.toString() + "/appointments?personId=" + personId);
		List<Appointment> appointments = this.restTemplate.exchange(appointmentService, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Appointment>>() {
		}).getBody();
		List<Registration> registrations = new ArrayList(appointments.size());
		appointments.forEach(appointment -> registrations.add(new Registration(person, appointment)));
		return registrations;
	}

}
