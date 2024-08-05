package com.use_cases;

import com.entities.Account;
import com.services.Bank_Functionalities;
import com.services.Bank_Functionalities_Impl;
import com.services.Bank_Impl;
import com.services.Bank_Interface;

public class Withdraw {
	public static void main(String[] args) {
		
		Account a1 = new Account();
		a1.setAadharcard(847470119049L);
		a1.setAccountHolderName("Kashish");
		a1.setAge(27);
		a1.setBalance(10000.0);
		a1.setEmail("kashishbansal369@gmail.com");
		a1.setPancard("DDFPB6664A");
		
		Bank_Interface bi = new Bank_Impl();
		bi.createAccount(a1);
		
		Bank_Functionalities bf = new Bank_Functionalities_Impl();
		bf.balanceCheck(a1.getAccountNumber());
		bf.withdrawAmount(a1, 200.50);
		bf.balanceCheck(a1.getAccountNumber());
		bf.withdrawAmount(a1, 2500.9);
		bf.balanceCheck(a1.getAccountNumber());
	}
}
