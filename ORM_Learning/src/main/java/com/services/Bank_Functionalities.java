package com.services;

import com.entities.Account;

public interface Bank_Functionalities {
	void withdrawAmount(Account account, Double amount);
	void creditAmount(Account account, Double amount);
	void balanceCheck(Account account);
	void updateProfile(Account account);
}
