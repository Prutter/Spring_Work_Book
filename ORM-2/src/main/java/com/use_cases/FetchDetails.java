package com.use_cases;

import com.services.BankServices;
import com.services.BankServicesImpl;

public class FetchDetails {
	public static void main(String[] args) {
		BankServices bs = new BankServicesImpl();
		
		bs.fetchAccount(1, "kashishbansal369@gmail.com", "Kashish");
	}
}
