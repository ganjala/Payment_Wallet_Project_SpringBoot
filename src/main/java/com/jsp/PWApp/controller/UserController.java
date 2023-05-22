package com.jsp.PWApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.PWApp.dto.Login;
import com.jsp.PWApp.dto.User;
import com.jsp.PWApp.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {
@Autowired
UserService userService;
@PostMapping("/users")
public User saveUser (@RequestBody User user) {
	return userService.saveUser(user);
}
@GetMapping("/users")
public List<User> getUserAll(){
	return userService.getAllUser();
}
@GetMapping("/users/{id}")
public User getById(@PathVariable int id) {
	return userService.getUserById(id);
}
@DeleteMapping("/users/{id}")
public User deleteUser(@PathVariable int id) {
	return userService.deleteUser(id);
}
@PutMapping("/users")
public User updateUser(@RequestBody User user, HttpServletRequest request) {
	return userService.updateUser(user, request);
}
@GetMapping("/users/login")
public User loginUser(@RequestBody Login login, HttpServletRequest request) {
	return userService.validateUser(login,request);
}
}
