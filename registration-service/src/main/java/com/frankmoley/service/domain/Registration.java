package com.frankmoley.service.domain;

public class Registration {
	private long appointmentId;
	private String appointmentName;
	private String dateTime;
	private String firstName;
	private String lastName;
	private String emailAddress;

	public Registration() {
		super();
	}

	public Registration(Person person, Appointment appointment) {
		super();
		this.appointmentId = appointment.getId();
		this.appointmentName = appointment.getName();
		this.dateTime = appointment.getDateTime();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.emailAddress = person.getEmailAddress();
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointmentName() {
		return appointmentName;
	}

	public void setAppointmentName(String appointmentName) {
		this.appointmentName = appointmentName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
