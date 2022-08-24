package com.example.demo.StepDefinitions;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Customer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;

@CucumberContextConfiguration
@SpringBootTest
public class StepDefinition {
	
	private Response response;
	//private RequestSpecification request;
	
	@Autowired
	private Customer customer;

	@Given("Id: {int} Name: {string}")
	public void id_name(Integer int1, String string) {
		customer.setId(int1);
		customer.setName(string);
		//request = given().contentType(ContentType.JSON).body(customer);
	   
	}

	@When("I invoke store data method")
	public void i_invoke_store_data_method() {
	 response =given().contentType(ContentType.JSON).body(customer).when().post("http://localhost:8080/customer");
	// System.out.println(response.prettyPrint());
	  
	}

	@Then("I verify the status: {int} Id: {int} in response body")
	public void i_verify_the_status_id_in_response_body(Integer int1, Integer int2) {
	 int status = response.then().extract().statusCode();
	 assertEquals(200,status);
	 response.then().assertThat().body("id", equalTo(int2));
	// assertEquals(int2,response.then().extract().re;
	}
}
