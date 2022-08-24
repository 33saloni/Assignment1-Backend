package com.example.demo.ServiceMapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;



import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;

@Mapper(componentModel="spring",unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface IServiceMapper {
	  
    CustomerDto customerToDTO(Customer customer);    
    Customer  DTOToCustomer(CustomerDto  dto);
    List<Customer>  DTOTListoCustomerList(List<CustomerDto>  dto);
    List<CustomerDto>  CustomerListtoDTOTList(List<Customer>  customer);
}

