package com.use_cases;

import com.entities.Account;
import com.services.BankServices;
import com.services.BankServicesImpl;

public class CreateAccount {
	public static void main(String[] args) {
		Account account = new Account();
		account.setAadharcard(847470119049L);
		account.setAccountHolderName("Kashish");
		account.setPancard("DDFPB6664A");
		account.setEmail("kashishbansal369@gmail.com");
		account.setAge(27);
		
		BankServices bs = new BankServicesImpl();
		bs.createAccount(account);
	}
}
