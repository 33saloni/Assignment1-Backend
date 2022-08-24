package com.example.demo;

import static org.junit.Assert.assertEquals;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.internal.MockitoCore;
//import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import  org.springframework.http.MediaType;

import com.example.demo.model.Customer;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class Assignment1ApplicationTests {

	  
	 @Autowired
	 private MockMvc mvc;
	 
	 @Autowired
	 Customer customer;

	 ObjectMapper mapper = new ObjectMapper();
	 
	 @Test
	 void getCustomers() throws Exception {
		
			MvcResult result = mvc.perform(get("/customers").contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			int status = result.getResponse().getStatus();
			assertEquals(200,status);
			String Result_String = result.getResponse().getContentAsString();
			Customer[] response = mapper.readValue(Result_String,Customer[].class);
			assertEquals(2,response.length);
		
			
		}
		
	@Test
	 void addCustomer() throws Exception {
		
		customer.setId(1);
		customer.setName("Harry");
		Customer customer1 = new Customer(2,"Ron");
		String Json_Customer = mapper.writeValueAsString(customer);
		String Json_Customer1 = mapper.writeValueAsString(customer1);
		MvcResult result = mvc.perform(post("/customer").content(Json_Customer).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		MvcResult result1 = mvc.perform(post("/customer").content(Json_Customer1).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200,status);
		String Result_String = result.getResponse().getContentAsString();
		Customer response = mapper.readValue(Result_String,Customer.class);
		assertEquals(Json_Customer,Result_String);
		
		int status1 = result1.getResponse().getStatus();
		assertEquals(200,status1);
		String Result_String1 = result1.getResponse().getContentAsString();
		//assertEquals(Json_Customer1,Result_String1);
		
		Customer response1 = mapper.readValue(Result_String1,Customer.class);
		assertEquals(customer1.getName(),response1.getName());
		
	}
	
	@Test
	 void healthcheck() throws Exception {
		
		MvcResult result = mvc.perform(get("/healthcheck").contentType(MediaType.APPLICATION_JSON)).andReturn();
		assertEquals(200,result.getResponse().getStatus());	
	}

}
