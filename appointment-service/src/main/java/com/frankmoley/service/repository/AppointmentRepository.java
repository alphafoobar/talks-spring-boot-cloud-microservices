package com.frankmoley.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frankmoley.service.entity.AppointmentEntity;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long> {
	Iterable<AppointmentEntity> findByPersonId(Long personId);
}
