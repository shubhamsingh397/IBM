package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Event;

public interface EventDao {

	public Event addEvent(Event event);
	public Event getEvent(long id);
	public List<Event> getAllEvent();
	public void deleteEvent(long id);
}
