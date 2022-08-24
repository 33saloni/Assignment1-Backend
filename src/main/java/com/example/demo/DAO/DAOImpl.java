package com.example.demo.DAO;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;


import com.example.demo.CustomExceptions.QueryException;
import com.example.demo.ServiceMapper.IServiceMapper;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;

@Repository("dbDAO")
public class DAOImpl implements DAOInterface{
	Logger logger = LoggerFactory.getLogger(DAOImpl.class);
	 @Autowired
	    JdbcTemplate jdbctemplate;
	 
	 @Autowired
		private IServiceMapper servicemapper;
	 
	 @Override
	 public void Add_Customer(CustomerDto customer) {
		 jdbctemplate.update("INSERT INTO CUSTOMER (id, name) VALUES ('"+customer.getId()+"','"+customer.getName()+"')");
		 logger.info("Data inserted in DB Successfully!");
		}
	@Override
	public List<CustomerDto> Get_Customer() {
		String query = "select * from customer";
		List<Customer> customers =jdbctemplate.query(query, new BeanPropertyRowMapper(Customer.class));
		logger.info("Data retrieved from DB Successfully!");
		return servicemapper.CustomerListtoDTOTList(customers);
		
		
	
	}
	@Override
	public void Health_Check() throws QueryException {
		try {
		 jdbctemplate.queryForObject("select * from customer where id=-1", new BeanPropertyRowMapper<Customer>(Customer.class));
		}catch(EmptyResultDataAccessException ex) {
			throw new QueryException("ExceptionRaisedForNegativeIndex");
		}catch(RuntimeException ex) {
			throw new QueryException(" ");
		}
	}
	
}
