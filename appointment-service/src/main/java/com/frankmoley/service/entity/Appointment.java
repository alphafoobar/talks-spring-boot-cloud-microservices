package com.frankmoley.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment {
	@Id
	@Column(name = "APPOINTMENT_ID")
	@GeneratedValue
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DATE_TIME")
	private String dateTime;
	@Column(name = "PERSON_ID")
	private Long personId;

	public Appointment() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
}
