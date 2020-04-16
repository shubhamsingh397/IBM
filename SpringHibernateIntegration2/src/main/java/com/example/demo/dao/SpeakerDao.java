package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Speaker;

public interface SpeakerDao {

	public Speaker addSpeaker(Speaker speaker);
	public Speaker getSpeaker(long id);
	public List<Speaker> getAllSpeaker();
	public void deleteSpeaker(long id);
}
