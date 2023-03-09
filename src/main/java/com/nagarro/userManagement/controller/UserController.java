package com.nagarro.userManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.userManagement.entity.User;
import com.nagarro.userManagement.repository.UserRepository;
import com.nagarro.userManagement.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}

	@PostMapping("/add")
	public User saveUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.userById(id);
	}

	@GetMapping("/search")
	public List<User> searchUsersByLastName(@RequestParam("last_name") String lastName) {
		return userService.fetchByLastName(lastName);
	}

	@GetMapping("/searchName")
	public List<User> searchUsersByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
		return userService.fetchByFirstNameAndLastName(firstName, lastName);
	}

	@PutMapping("/update/{id}")
	public User update(@PathVariable Long id, @RequestBody User updatedUser) {
		return userService.updateUser(id, updatedUser);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}
