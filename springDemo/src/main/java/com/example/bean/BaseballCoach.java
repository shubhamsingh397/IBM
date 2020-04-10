package com.example.bean;

import lombok.Setter;

@Setter
public class BaseballCoach implements Coach {

	private FortuneService fortuneService;
	@Override
	public String getDailyWorkout() {
	
		return "practice today";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
