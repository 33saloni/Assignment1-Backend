package com.example.demo.CustomExceptions;

public class QueryException extends RuntimeException{
	
	public QueryException (String message) {
		super(message);
	}

}
