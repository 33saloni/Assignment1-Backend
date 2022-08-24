package com.example.demo.DAO;
import com.example.demo.CustomExceptions.QueryException;
import com.example.demo.model.CustomerDto;

import java.util.List;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;
public interface DAOInterface  {
	public void Add_Customer(CustomerDto customer);
	public List<CustomerDto> Get_Customer();
	public void Health_Check() throws QueryException;
}
