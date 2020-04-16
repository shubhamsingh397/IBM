package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eventId;
	private String eventName;
	private Date eventDate;
	private Time eventTime;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Speaker speaker;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Time getEventTime() {
		return eventTime;
	}

	public void setEventTime(Time eventTime) {
		this.eventTime = eventTime;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public Event( String eventName, Date eventDate, Time eventTime) {
		super();
		
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		
	}

	public Event() {
		super();
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventTime="
				+ eventTime  + "]";
	}
	
	
	
}
