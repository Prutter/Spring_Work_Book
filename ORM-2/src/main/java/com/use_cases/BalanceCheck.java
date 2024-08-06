package com.use_cases;

import com.services.BankServices;
import com.services.BankServicesImpl;

public class BalanceCheck {
	public static void main(String[] args) {
		BankServices bs = new BankServicesImpl();
		
		bs.balanceAmount(2, "kashishbansal369@gmail.com");
	}
}
