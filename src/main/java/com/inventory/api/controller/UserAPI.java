package com.inventory.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.User;
import com.inventory.entity.ValidateUserCredentials;
import com.inventory.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/user")
public class UserAPI {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Operation(summary = " Add New User / Register User ", description = "User Object must be send in Request Payload ")
	
	@ApiResponse(responseCode = "200", description = "Success")
	@ApiResponse(responseCode = "201", description = "Success Created")
	@ApiResponse(responseCode = "400", description = "Invalid Request Payload")
	@ApiResponse(responseCode = "500", description = "Internal server error")
	

	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userCreated = userServiceImpl.addNewUser(user);
		return new ResponseEntity<User>(userCreated, HttpStatus.OK);
	}
     @Operation(summary = " Validate UserName and Password ", description = " UserName and password must be send in the Request Payload ")
	
	@ApiResponse(responseCode = "200", description = "Success")
	@ApiResponse(responseCode = "400", description = "Invalid Request Payload")
	@ApiResponse(responseCode = "500", description = "Internal server error")
	
	
	@PostMapping("/validate")
	public ResponseEntity<Boolean> validUser(@RequestBody ValidateUserCredentials user) {
		boolean valid= userServiceImpl.validateUser(user.getUserName(),user.getPassword());
		return new ResponseEntity<>(valid, HttpStatus.OK);
	}
}
