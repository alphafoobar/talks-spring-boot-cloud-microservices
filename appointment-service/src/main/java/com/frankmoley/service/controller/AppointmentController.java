package com.frankmoley.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frankmoley.service.entity.Appointment;
import com.frankmoley.service.repository.AppointmentRepository;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentRepository appointmentRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Appointment> getAll(@RequestParam(required = false) Long personId) {
		if (null == personId) {
			return this.appointmentRepository.findAll();
		}
		return this.appointmentRepository.findByPersonId(personId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Appointment add(@RequestBody Appointment appointment) {
		return this.appointmentRepository.save(appointment);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Appointment getOne(@PathVariable long id) {
		return this.appointmentRepository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Appointment update(@PathVariable long id, @RequestBody Appointment appointment) {
		appointment.setId(id);
		return this.appointmentRepository.save(appointment);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		this.appointmentRepository.delete(id);
	}
}