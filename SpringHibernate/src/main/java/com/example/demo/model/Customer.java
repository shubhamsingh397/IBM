package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class Customer implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2548228068020266657L;
	
	@Id
	@GeneratedValue
	private long customerId;
	private String customerName;
	private String customerEmail;
	private boolean isActive;
	
	
	
}
