package com.jsp.PWApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.PWApp.dao.UserDao;
import com.jsp.PWApp.dto.Login;
import com.jsp.PWApp.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
	@Autowired
UserDao userdao;
	public User saveUser(User user) {
		return userdao.saveUser(user);
	} 
	public List<User> getAllUser(){
		return userdao.getAllUse();
	}
	public User getUserById(int id) {
		return userdao.getUserById(id);
	}
	public User updateUser(User user, HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user2= userdao.updateUser(user);
		if(user2!=null) {
			session.setAttribute("user2", user2);
		}
		return user2;
	}
	public User deleteUser(int id) {
		return userdao.deleteUser(id);
	}
	public User validateUser(Login login, HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user=userdao.validateUser(login);
		if(user !=null) {
			session.setAttribute("user", user);
		}
		return user;
	}
}
