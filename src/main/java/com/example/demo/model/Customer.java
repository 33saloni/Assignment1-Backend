package com.example.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	@Min(value = 0, message = "Id can't be less than 1")
	@NotBlank
	private int id;
	@NotEmpty(message = "name should not be empty")
	private String name;

	public Customer() {
		super();
	}
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
	
}