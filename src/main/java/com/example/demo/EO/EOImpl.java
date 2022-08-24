package com.example.demo.EO;

import java.util.List;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.BO.BOImpl;
import com.example.demo.CustomExceptions.QueryException;
import com.example.demo.DAO.DAOInterface;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;

@Component("entityobj")
public class EOImpl implements EOInterface{
	Logger logger = LoggerFactory.getLogger(EOImpl.class);
	@Autowired
	private DAOInterface dbDAO;
	

	
	@Override
	public void Add_Customer(CustomerDto customer) {
		logger.info("Received data from BO Layer passing it to DAO!");
		dbDAO.Add_Customer(customer);
		
	}

	@Override
	public List<CustomerDto> Get_Customer() {
		
		logger.info("Received data from DAO Layer!");
		return  dbDAO.Get_Customer();
		
	}

	@Override
	public void Health_Check() throws  QueryException {
		     dbDAO.Health_Check();				
	}

	

}

