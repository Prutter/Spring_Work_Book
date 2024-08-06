package com.services;

import com.entities.Account;
import com.entities.AccountDTO;

public interface BankServices {
	boolean findAccount(Integer accountNumber);
	void createAccount(Account account);
	void creditAmount(Integer accountNumber, Double amount);
	void withdrawAmount(Integer accountNumber, String email, Double amount);
	void fetchAccount(Integer accountNumber, String email, String name);
	void balanceAmount(Integer accountnumber, String email);
	void updateAccount(Integer accountnumber, AccountDTO accountDto);
}
