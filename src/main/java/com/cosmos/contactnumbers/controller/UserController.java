package com.cosmos.contactnumbers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmos.contactnumbers.model.Users;
import com.cosmos.contactnumbers.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping
	public Users saveUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}

	@GetMapping("/{mobileNumber}")
	public Optional<Users> getUserByMobileNumber(@PathVariable Long mobileNumber) {
		return userService.getUserByMobileNumber(mobileNumber);
	}

	@PutMapping()
	public Optional<Users> updateByMobileNumber(@PathVariable Long mobileNumber, @RequestBody Users user) {
		return userService.updateByMobileNumber(mobileNumber, user);
	}

	@GetMapping("/backup")
	public String backupUsers() {
		return userService.backupUsers();
	}

	// enable when u want to copy from excel file

	@PostMapping("/fromprop")
	public String addUsersFromFile() {
		String str = "Success";
		try {
			str = userService.addUsersFromFile();
		} catch (Exception e) {
			str = "Not able to update.Check if excel file there."+e;
		}
		return str;
	}

}
