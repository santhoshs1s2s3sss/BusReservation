package com.capg.brs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.brs.entity.User;
import com.capg.brs.exceptions.UserNotFoundException;
import com.capg.brs.service.IUserService;


@RestController
@RequestMapping("/Bus")
@CrossOrigin("http://localhost:4200")

public class UserController {
	@Autowired
	private IUserService service;
	
	
	
	@PostMapping("/create")
	public ResponseEntity<String> Register(@RequestBody User user ){
			if(user.getPassword().equals(user.getConfirmpassword())) {
				service.register(user);
				ResponseEntity<String> responseEntity = new ResponseEntity<String>("Account created successfully",HttpStatus.OK);
				return responseEntity;
			}
			else {
				ResponseEntity<String> responseEntity = new ResponseEntity<String>("Please check your details",HttpStatus.INTERNAL_SERVER_ERROR);
				return responseEntity;
			}
			
		}
	
	
	
	
	
	
	
	@GetMapping("/userlogin/{userId}/{password}")
	public ResponseEntity<User> userLogin(@PathVariable("userId") int userId,@PathVariable("password") String password)
	{
		
		System.out.println(userId);
		System.out.println(password);
		User login=service.userLogin(userId, password);
		if(login==null)
		{
			throw new UserNotFoundException("User does not exist");
		}
		else
		{
			return new ResponseEntity<User>(login, new HttpHeaders(), HttpStatus.OK);
		}
	}
}