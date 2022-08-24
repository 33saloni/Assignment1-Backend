package com.example.demo.BO;

import java.util.List;

import com.example.demo.HealthCheck.HealthCheck;
import com.example.demo.model.CustomerDto;

public interface BOInterface {
	
	public void Add_Customer(CustomerDto customer);
	public  List<CustomerDto> Get_Customer();
	public HealthCheck  DB_Health_Check();
	public List<HealthCheck> HealthCheck();
}
