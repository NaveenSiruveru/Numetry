package com.rest3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest3.jwtUtil.JwtUtill;
import com.rest3.model.TheUser;
import com.rest3.model.UserRequest;
import com.rest3.model.UserResponce;
import com.rest3.service.IUserService;


@RestController
@RequestMapping("/user")
public class TheUserController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private JwtUtill util;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody TheUser theUser) {
		Integer id=iUserService.saveUser(theUser);
		String body="user '"+id+"' saved";
		return ResponseEntity.ok(body);
	}
	@PostMapping("/login")
	public ResponseEntity<UserResponce> loginUser(@RequestBody UserRequest userRequest){
		String token=util.generateToken(userRequest.getUsername());
		return ResponseEntity.ok(new UserResponce(token,"sucess"));
	}
	

}
