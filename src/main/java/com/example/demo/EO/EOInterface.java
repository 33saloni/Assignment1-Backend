package com.example.demo.EO;

import java.util.List;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;

import com.example.demo.CustomExceptions.QueryException;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;

public interface EOInterface {

	public void Add_Customer(CustomerDto customer);
	public  List<CustomerDto> Get_Customer();
	public void Health_Check() throws  QueryException;
}
