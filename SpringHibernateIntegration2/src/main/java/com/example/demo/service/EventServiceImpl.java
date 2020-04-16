package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EventDao;
import com.example.demo.model.Event;
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao dao;
	public Event addEvent(Event event) {
		// TODO Auto-generated method stub
		return dao.addEvent(event);
	}

	public Event getEvent(long id) {
		// TODO Auto-generated method stub
		return dao.getEvent(id);
	}

	public List<Event> getAllEvent() {
		// TODO Auto-generated method stub
		return dao.getAllEvent();
	}

	public void deleteEvent(long id) {
		// TODO Auto-generated method stub
		dao.deleteEvent(id);
	}
	

}
