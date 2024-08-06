package com.use_cases;

import com.services.BankServices;
import com.services.BankServicesImpl;

public class Deposit {
	public static void main(String[] args) {
		BankServices bs = new BankServicesImpl();
		
		bs.creditAmount(2, 1000.0);
	}
}
