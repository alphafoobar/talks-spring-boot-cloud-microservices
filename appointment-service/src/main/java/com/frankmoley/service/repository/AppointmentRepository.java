package com.frankmoley.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frankmoley.service.entity.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	List<Appointment> findByPersonId(long personId);
}
