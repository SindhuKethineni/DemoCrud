package com.example.BasicCrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BasicCrud.model.User;
import com.example.BasicCrud.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}

	@PostMapping("/save")
	public User createUser(@RequestBody User user)
	{
		return userRepository.save(user);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user) {

	        User updatedUser = userRepository.findById(id);

	        updatedUser.setUsername(user.getUsername());

	        updatedUser.setEmail(user.getEmail());

	        userRepository.save(updatedUser);

	        return new ResponseEntity("updated successfully", HttpStatus.OK);

	    }



}
