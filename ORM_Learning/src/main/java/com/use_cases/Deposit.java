package com.use_cases;

import com.entities.Account;
import com.services.Bank_Functionalities;
import com.services.Bank_Functionalities_Impl;
import com.services.Bank_Impl;
import com.services.Bank_Interface;

public class Deposit {
	public static void main(String[] args) {
		Account a2 = new Account();
		a2.setAadharcard(847470119050L);
		a2.setAccountHolderName("Kashish");
		a2.setAge(27);
		a2.setBalance(10000.0);
		a2.setEmail("kashishbansal044@gmail.com");
		a2.setPancard("DDFPB6664B");
		
		
		Bank_Interface bi = new Bank_Impl();
		bi.createAccount(a2);
		Bank_Functionalities bf = new Bank_Functionalities_Impl();
		
		bf.creditAmount(2, 1400.0);
		bf.balanceCheck(2);
	}
}
