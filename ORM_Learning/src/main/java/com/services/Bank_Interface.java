package com.services;

import com.entities.Account;

public interface Bank_Interface {
	boolean createAccount(Account account);
	boolean findAccount(Long accountNumber);
	boolean	updateAccount(Account account);
	boolean deleteAccount(Long accountNumber);
}	
