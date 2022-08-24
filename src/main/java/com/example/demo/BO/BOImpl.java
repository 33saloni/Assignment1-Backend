package com.example.demo.BO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.CustomExceptions.QueryException;

import com.example.demo.EO.EOInterface;
import com.example.demo.HealthCheck.HealthCheck;


import com.example.demo.model.CustomerDto;

@Service("bo")
public class BOImpl implements BOInterface{
	Logger logger = LoggerFactory.getLogger(BOImpl.class);
	
	@Autowired
	private EOInterface entityobj;
	

	
	@Override
	public void Add_Customer(CustomerDto customer) {
		logger.info("Received data from controller, passing it to EO Layer!");
		 entityobj.Add_Customer(customer);
		
	}

	@Override
	public  List<CustomerDto> Get_Customer() {
		List<CustomerDto> result = entityobj.Get_Customer();
		logger.info("Received data from EO Layer!");
		return result;
		
	}

	@Override
	public HealthCheck DB_Health_Check() {
		try {
		entityobj.Health_Check();
		}catch ( QueryException ex) {
			if(StringUtils.isNotBlank(ex.getMessage()) && "ExceptionRaisedForNegativeIndex".equalsIgnoreCase(ex.getMessage())) {
				return new HealthCheck("CustomerDB","Successful","Database Call Successful");
				
			}
			else{
				return new HealthCheck("CustomerDB","Failed","Database Call Failed");
				
			}
			
		}
		return null;	
	}

	public List<HealthCheck> HealthCheck() {
		List<HealthCheck> list = new ArrayList<>();
		list.add(DB_Health_Check());
		return list;
	}

}

