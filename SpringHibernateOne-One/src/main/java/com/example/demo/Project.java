package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String projectName;
	private boolean isComplete;

	public Project() {

	}

	@OneToOne(mappedBy = "project",cascade = CascadeType.ALL)
	private Student student;

	public Project(String projectName, boolean isComplete) {
		super();
		this.projectName = projectName;
		this.isComplete = isComplete;
	}

	
}
