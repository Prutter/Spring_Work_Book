package com.services;

import com.entities.Account;

public interface Bank_Interface {
	void createAccount(Account account);
	boolean findAccount(Integer accountNumber);
	boolean	updateAccount(Account account);
	boolean deleteAccount(Integer accountNumber);
	Account fetchDetails(Integer accountNumber);
}	
