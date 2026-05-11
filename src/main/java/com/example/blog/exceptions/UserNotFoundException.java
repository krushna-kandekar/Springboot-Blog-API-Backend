package com.example.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException{

	String userName;
	String fieldName;
	String fieldValue;
	
	public UserNotFoundException(String userName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s : %s", userName, fieldName, fieldValue));
		this.userName = userName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
