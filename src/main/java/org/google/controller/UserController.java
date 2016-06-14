package org.google.controller;

import java.util.List;

import org.google.controller.advice.ResourceNotFoundException;
import org.google.entities.User;
import org.google.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userRepository.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		User u = userRepository.save(user);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user) throws ResourceNotFoundException {
		User existingUser =userRepository.findOne(user.getId());
		if(existingUser == null){
			throw new ResourceNotFoundException("User with id "+user.getId() + " Not found");
		}
		User u = userRepository.save(user);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@RequestParam("id")Long userId) {
		userRepository.delete(userId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
