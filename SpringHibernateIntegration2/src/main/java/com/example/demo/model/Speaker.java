package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Speaker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long spearkerId;
	private String speakerName;
	private String speakerEmail;
	private boolean isAvailable;
	
	@OneToMany(mappedBy = "speaker", cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Event> event;

	public long getSpearkerId() {
		return spearkerId;
	}

	public void setSpearkerId(long spearkerId) {
		this.spearkerId = spearkerId;
	}

	public String getSpeakerName() {
		return speakerName;
	}

	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}

	public String getSpeakerEmail() {
		return speakerEmail;
	}

	public void setSpeakerEmail(String speakerEmail) {
		this.speakerEmail = speakerEmail;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}
	
	public void addEvent(Event event) {
		this.event.add(event);
	}

	public Speaker(String speakerName, String speakerEmail, boolean isAvailable) {
		super();
		
		this.speakerName = speakerName;
		this.speakerEmail = speakerEmail;
		this.isAvailable = isAvailable;
		
	}

	public Speaker() {
		super();
	}

	@Override
	public String toString() {
		return "Speaker [spearkerId=" + spearkerId + ", speakerName=" + speakerName + ", speakerEmail=" + speakerEmail
				+ ", isAvailable=" + isAvailable + ", event=" + event + "]";
	}
	
	
}
