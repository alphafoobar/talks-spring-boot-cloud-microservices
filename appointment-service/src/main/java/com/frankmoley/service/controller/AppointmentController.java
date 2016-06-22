package com.frankmoley.service.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frankmoley.service.domain.Appointment;
import com.frankmoley.service.service.AppointmentService;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Appointment>> getAll(@RequestParam(required = false) Long personId) {
		List<Appointment> appointments = this.appointmentService.findAll(personId);
		return new ResponseEntity(appointments, CollectionUtils.isEmpty(appointments) ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
		Appointment newAppointment = this.appointmentService.addOrUpdate(appointment);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/appointments/" + appointment.getId()));
		return new ResponseEntity(newAppointment, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Appointment> findOne(@PathVariable Long id) {
		return new ResponseEntity(this.appointmentService.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment appointment) {
		appointment.setId(id);
		return new ResponseEntity(this.appointmentService.addOrUpdate(appointment), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Appointment> delete(@PathVariable Long id) {
		this.appointmentService.delete(id);
		return new ResponseEntity(null, HttpStatus.RESET_CONTENT);
	}

}
