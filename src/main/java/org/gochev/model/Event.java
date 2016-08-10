package org.gochev.model;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Event extends AbstractEntity {
	
	private static final long serialVersionUID = 3144694279655082093L;

	@NotEmpty
	private String title;
	@NotEmpty
	private String description;
	@NotEmpty
	private String location;
	
	private double latitude;
	private double longitude;
	
	@NotNull
	@Column(name = "startTime")
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    private Date startTime;
	
	@OneToMany(mappedBy="event")
	private Set<Attendee> attendees = Collections.emptySet();;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Set<Attendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(Set<Attendee> attendees) {
		this.attendees = attendees;
	}
	
}
