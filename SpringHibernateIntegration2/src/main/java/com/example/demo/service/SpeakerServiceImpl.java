package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SpeakerDao;
import com.example.demo.model.Speaker;
@Service
public class SpeakerServiceImpl implements SpeakerService{

	@Autowired
	private SpeakerDao dao;
	public Speaker addSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		return dao.addSpeaker(speaker);
	}

	public Speaker getSpeaker(long id) {
		// TODO Auto-generated method stub
		return dao.getSpeaker(id);
	}

	public List<Speaker> getAllSpeaker() {
		// TODO Auto-generated method stub
		return dao.getAllSpeaker();
	}

	public void deleteSpeaker(long id) {
		// TODO Auto-generated method stub
		dao.deleteSpeaker(id);
	}

}
