package com.nagarro.userManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.nagarro.userManagement.entity.User;
import com.nagarro.userManagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User userById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}

	public User updateUser(Long id, User updatedUser) {
		return userRepository.save(updatedUser);
	}

	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return " deleted successfully";
	}

	public List<User> fetchByFirstNameAndLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public List<User> fetchByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
		
	}

}
