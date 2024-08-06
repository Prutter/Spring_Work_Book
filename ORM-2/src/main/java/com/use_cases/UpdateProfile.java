package com.use_cases;

import com.entities.AccountDTO;
import com.services.BankServices;
import com.services.BankServicesImpl;

public class UpdateProfile {
	public static void main(String[] args) {
		BankServices bs = new BankServicesImpl();
		
		AccountDTO accountDto = new AccountDTO();
		accountDto.setAccountHolderName("K.B.");
		accountDto.setAge(28);
		accountDto.setEmail("kbmainbox@gmail.com");
		
		bs.updateAccount(2, accountDto);
	}
}
