package com.example.demo.controller;


import java.util.List;


import javax.validation.Valid;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;
import com.example.demo.BO.BOInterface;
import com.example.demo.HealthCheck.HealthCheck;
import com.example.demo.ServiceMapper.IServiceMapper;


@RestController
//@RequestMapping("/backend")
public class Controller {
	
	Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private BOInterface bo;
	
	@Autowired
	private IServiceMapper servicemapper;
	
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> postCustomer(@Valid @RequestBody Customer customer){
		CustomerDto dto = servicemapper.customerToDTO(customer);
		bo.Add_Customer(dto);
		logger.info("Data sent to BO Layer!");
		return new ResponseEntity<>(customer ,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<CustomerDto> customers = bo.Get_Customer();
		logger.info("Received Data from BO");
		List<Customer> result = servicemapper.DTOTListoCustomerList(customers);
		if(customers!=null && !customers.isEmpty())
			return new ResponseEntity<>(result,HttpStatus.OK);
		else
			return new ResponseEntity<>(result,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/healthcheck")
	public ResponseEntity<List<HealthCheck>> checkHealth(){	
		ResponseEntity<List<HealthCheck>> value = null;
		List<HealthCheck> result = bo.HealthCheck();
		if(result!=null)
			value = new ResponseEntity<>(result,HttpStatus.OK);
		return value;
	}


}
