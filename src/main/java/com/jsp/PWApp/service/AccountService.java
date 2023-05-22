package com.jsp.PWApp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.PWApp.dao.AccountDao;
import com.jsp.PWApp.dto.Account;
import com.jsp.PWApp.dto.User;

import jakarta.servlet.http.HttpSession;

@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;
	public Account saveAccount(Account account, HttpSession session) {
		if(account !=null && session !=null) {
			User user=(User) session.getAttribute("user");
			account.setUser(user);
			Account account2= accountDao.saveAccount(account);
			if(account2!=null) {
				session.setAttribute("account", account2);
				return account2;
			}
		}
		return null;
		
		
	}
	public List<Account> getAccount(){
		return accountDao.getAccount();
	}
	public Account getAccountById(int id) {
		return accountDao.getAccountById(id);
	}
	public Account updateAccount(Account account, HttpSession session) {
		if(account !=null && session !=null) {
			User user2=(User) session.getAttribute("user2");
			account.setUser(user2);
			return  accountDao.updateAccount(account);
			
			}
		
		return null;
		}
		
	
	public Account deleteAccount(int id) {
		return accountDao.deleteAccount(id);
	}
	public Account sendAmount(double amt, HttpSession session) {
		if(amt>0) {
			Account account=(Account) session.getAttribute("account");
			if(account!=null) {
				double result=account.getAmount()-amt;
				if(account.getAmount()>amt) {
				account.setAmount(result);
				return accountDao.updateAccount(account);
				}
			}
		}
		return null;
	}
	public Account RAmount(double amt, HttpSession session) {
		if(amt>0) {
			Account account=(Account) session.getAttribute("account");
			if(account!=null) {
				double result=account.getAmount()+amt;
				
				account.setAmount(result);
				return accountDao.updateAccount(account);
				
			}
	}
		return null;
	}
	public Account checkBalance(HttpSession session) {
		Account account=(Account) session.getAttribute("account");
		if(account!=null) {
			return accountDao.getAccountById(account.getId());
		}
		return null;
	}
	
}
