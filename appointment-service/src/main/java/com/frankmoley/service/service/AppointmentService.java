package com.frankmoley.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frankmoley.service.domain.Appointment;
import com.frankmoley.service.entity.AppointmentEntity;
import com.frankmoley.service.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private AppointmentTranslator appointmentTranslator;

	public List<Appointment> findAll(Long personId) {
		Iterable<AppointmentEntity> appointmentEntities = null;
		if (null == personId) {
			appointmentEntities = this.appointmentRepository.findAll();
		} else {
			appointmentEntities = this.appointmentRepository.findByPersonId(personId);
		}
		List<Appointment> appointments = new ArrayList();
		appointmentEntities.forEach(appointmentEntity -> appointments.add(this.appointmentTranslator.translateAppointmentEntityToAppointment(appointmentEntity)));
		return appointments;
	}

	public Appointment findOne(Long id) {
		AppointmentEntity entity = this.appointmentRepository.findOne(id);
		return this.appointmentTranslator.translateAppointmentEntityToAppointment(entity);
	}

	public Appointment addOrUpdate(Appointment appointment) {
		AppointmentEntity entity = this.appointmentRepository.save(this.appointmentTranslator.translateAppointmentToAppointmentEntity(appointment));
		return this.appointmentTranslator.translateAppointmentEntityToAppointment(entity);
	}

	public void delete(long appointmentId) {
		this.appointmentRepository.delete(appointmentId);
	}
}
