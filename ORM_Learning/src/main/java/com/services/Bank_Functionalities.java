package com.services;

import com.entities.Account;
import com.entities.AccountDTO;

public interface Bank_Functionalities {
	void withdrawAmount(Account account, Double amount);
	void creditAmount(Integer accountNumber, Double amount);
	void balanceCheck(Integer accountNumber);
	void updateProfile(Integer accountNumber, AccountDTO accountDto);
}
