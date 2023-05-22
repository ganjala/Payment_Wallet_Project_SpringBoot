package com.jsp.PWApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.PWApp.dto.Account;
import com.jsp.PWApp.repository.AccountRepository;

@Repository
public class AccountDao {
@Autowired
AccountRepository accountRepository;
public Account saveAccount(Account account) {
	return accountRepository.save(account);
}
public List<Account> getAccount(){
	return accountRepository.findAll();
}
public Account getAccountById(int id) {
	Optional<Account> optional=accountRepository.findById(id);
	return optional.get();
}
public Account updateAccount(Account account) {
	Optional<Account> optional=accountRepository.findById(account.getId());
	if(optional.isPresent()) {
		return accountRepository.save(account);
	}
	return optional.get();
}
public Account deleteAccount(int id) {
	Optional<Account> optional=accountRepository.findById(id);
	if(optional.isPresent()) {
		 accountRepository.delete(optional.get());
	}
	return null;
}
}
