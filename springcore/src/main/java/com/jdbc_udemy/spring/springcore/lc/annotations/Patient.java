package com.jdbc_udemy.spring.springcore.lc.annotations;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Patient {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("Inside the setter method");
		this.id = id;
	}
	
	@PostConstruct
	public void hi() {
		System.out.println("Inside hi method");
	}
	
	@PreDestroy
	public void bye() {
		System.out.println("Inside bye method");
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + "]";
	}

	public Patient() {	
		super();
		System.out.println("Inside contructor called");
		// TODO Auto-generated constructor stub
	}
	
}

