package com.frankmoley.service.domain;

public class Appointment {

	private long id;
	private String name;
	private String dateTime;
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Appointment{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", dateTime='").append(dateTime).append('\'');
		sb.append(", personId=").append(personId);
		sb.append('}');
		return sb.toString();
	}
}
