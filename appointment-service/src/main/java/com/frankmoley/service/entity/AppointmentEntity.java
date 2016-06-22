package com.frankmoley.service.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPOINTMENT")
public class AppointmentEntity {

	@Id
	@GeneratedValue
	@Column(name = "APPOINTMENT_ID")
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DATE_TIME")
	private Timestamp dateTime;
	@Column(name = "PERSON_ID")
	private Long personId;

	public AppointmentEntity() {
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

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AppointmentEntity{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", dateTime=").append(dateTime);
		sb.append(", personId=").append(personId);
		sb.append('}');
		return sb.toString();
	}
}
