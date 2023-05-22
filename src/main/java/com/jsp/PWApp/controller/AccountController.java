package com.jsp.PWApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.jsp.PWApp.dto.Account;
import com.jsp.PWApp.service.AccountService;

import jakarta.servlet.http.HttpSession;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;
	@PostMapping("/accounts")
	public Account saveAccount(@RequestBody Account account, HttpSession session) {
		return accountService.saveAccount(account, session);
	}
//	@GetMapping("/accounts")
//	public List<Account> getAccount(){
//		return accountService.getAccount();
//	}
	@GetMapping("/accounts/{id}")
	public Account getAccountById(@PathVariable int id) {
		
		return accountService.getAccountById(id);
	}
	@PutMapping("/accounts/{id}")
	public Account updateAccount(@RequestBody Account account, HttpSession session) {
		return accountService.updateAccount(account, session);
		}
		@DeleteMapping("/accounts/{id}")
public Account deleteAccount(@PathVariable int id) {
		return accountService.deleteAccount(id);
	}
		@PatchMapping("/accounts/{amt}")
		public Account sendMoney(@PathVariable double amt, HttpSession session) {
			return accountService.sendAmount(amt, session);
		}
		@PatchMapping("/accounts")
		public Account RAmount(double amt, HttpSession session) {
			return accountService.RAmount(amt, session);
		}
		@GetMapping("/accounts/display")
		public Account checkBalance(HttpSession session) {
			return accountService.checkBalance(session);
		}
}
