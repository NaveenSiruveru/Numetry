package com.rest3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest3.model.TheUser;
import com.rest3.repository.TheUserRepo;
import com.rest3.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	
	@Autowired
	private TheUserRepo theUserRepo;
	
	
	
	@Override
	public Integer saveUser(TheUser theUser) {
		
		return theUserRepo.save(theUser).getId();
		
	}

}
