package com.use_cases;

import com.services.BankServices;
import com.services.BankServicesImpl;

public class Withdraw {
	public static void main(String[] args) {
		BankServices bs = new BankServicesImpl();
		
		bs.withdrawAmount(2, "kashishbansal369@gmail.com", 500.0);
		
	}
}
