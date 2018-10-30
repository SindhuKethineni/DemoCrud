package com.example.BasicCrud.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BasicCrud.model.User;
import com.example.BasicCrud.repository.UserRepository;

public class UserServiceImpl {
	@Autowired
	UserRepository userRepository;
	public void setUserRepository(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}
	

	public User findById(Long id) {
		
		

		return userRepository.findById(id);
	}
	
}
