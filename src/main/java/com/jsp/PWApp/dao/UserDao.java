package com.jsp.PWApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.PWApp.dto.Login;
import com.jsp.PWApp.dto.User;
import com.jsp.PWApp.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository repository;
	//save
public User saveUser(User user) {
	return repository.save(user);
}
//getAll
public List<User> getAllUse(){
	return repository.findAll();
}
public User getUserById(int id) {
	Optional<User> optional=repository.findById(id);
	return optional.get();
}
public User updateUser(User user) {
	Optional<User> optional=repository.findById(user.getId());
	if(optional.get()!=null) {
	 repository.save(optional.get());
	 return user;
	}
	return null;
	
	}
public User deleteUser(int id) {
	Optional<User> optional=repository.findById(id);
	if(optional.get()!=null) {
		 repository.delete(optional.get());
	}
	return optional.get();
}
public User validateUser(Login login) {
 return repository.validateUser(login.getEmail(), login.getPassword());
}
}
