package com.frankmoley.service.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.frankmoley.service.domain.Appointment;
import com.frankmoley.service.entity.AppointmentEntity;

@Service
public class AppointmentTranslator {

	public Appointment translateAppointmentEntityToAppointment(AppointmentEntity entity) {
		Appointment appointment = new Appointment();
		appointment.setName(entity.getName());
		appointment.setDateTime(convertDateTimeToString(entity.getDateTime()));
		appointment.setPersonId(entity.getPersonId());
		return appointment;
	}

	public AppointmentEntity translateAppointmentToAppointmentEntity(Appointment appointment) {
		AppointmentEntity entity = new AppointmentEntity();
		entity.setId(appointment.getId());
		entity.setDateTime(new Timestamp(this.convertStringToDateTime(appointment.getDateTime()).getTime()));
		entity.setName(appointment.getName());
		entity.setPersonId(appointment.getPersonId());
		return entity;
	}

	private static final String DATE_FORMAT = "yyyy.MM.dd 'at' hh:mm:ss z";

	private String convertDateTimeToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		return formatter.format(date);
	}

	private Date convertStringToDateTime(String dateTimeString) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		try {
			return formatter.parse(dateTimeString);
		} catch (ParseException e) {
			throw new IllegalStateException("error parsing date string", e);
		}
	}
}
