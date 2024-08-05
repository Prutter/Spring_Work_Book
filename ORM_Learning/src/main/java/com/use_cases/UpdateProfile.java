package com.use_cases;

import com.entities.AccountDTO;
import com.services.Bank_Functionalities;
import com.services.Bank_Functionalities_Impl;

public class UpdateProfile {
	public static void main(String[] args) {
		Bank_Functionalities bf = new Bank_Functionalities_Impl();
		
		AccountDTO accdto = new AccountDTO();
		accdto.setAccountHolderName("K.B.");
		accdto.setAge(28);
		accdto.setEmail("kbmainbox@gmail.com");
		
		bf.updateProfile(2, accdto );
	}
}
