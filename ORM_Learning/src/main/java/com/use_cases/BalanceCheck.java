package com.use_cases;

import com.services.Bank_Functionalities;
import com.services.Bank_Functionalities_Impl;

public class BalanceCheck {
	public static void main(String[] args) {
		Bank_Functionalities bf = new Bank_Functionalities_Impl();
		
		bf.balanceCheck(2);
	}
}
