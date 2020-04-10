package com.example.bean;

public class DailyFortuneService implements FortuneService{

	

	@Override
	public String getFortune() {
		
		return "today is your lucky day";
	}
	
	
}
