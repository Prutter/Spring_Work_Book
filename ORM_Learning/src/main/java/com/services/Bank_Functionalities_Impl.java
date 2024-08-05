package com.services;

import javax.persistence.EntityManager;

import com.entities.Account;
import com.entities.AccountDTO;
import com.utility.EM_Utility;

public class Bank_Functionalities_Impl implements Bank_Functionalities{

	@Override
	public void withdrawAmount(Account account, Double amount) {
		Bank_Interface bi = new Bank_Impl();
		if(bi.findAccount(account.getAccountNumber())) {
			account.setBalance(account.getBalance()-amount);
			bi.updateAccount(account);
		}else {
			System.out.println("No account found as mentioned.");
		}
		
	}

	@Override
	public void creditAmount(Integer accountNumber, Double amount) {
		Bank_Interface bi = new Bank_Impl();
		if(bi.findAccount(accountNumber)) {
			EntityManager em = EM_Utility.provideEntityManager();
			Account account = em.find(Account.class, accountNumber);
			account.setBalance(account.getBalance() + amount);
			bi.updateAccount(account);
		}else {
			System.out.println("No account found as mentioned.");
		}
	}

	@Override
	public void balanceCheck(Integer accountNumber) {
		Bank_Interface bi = new Bank_Impl();
		if(bi.findAccount(accountNumber)) {
			Account acc = bi.fetchDetails(accountNumber);
			System.out.println(acc.getBalance());
		}else {
			System.out.println("No account found as mentioned.");
		}
	}

	@Override
	public void updateProfile(Integer accountNumber, AccountDTO accountDto) {
		Bank_Interface bi = new Bank_Impl();
		if(bi.findAccount(accountNumber)) {
			EntityManager em = EM_Utility.provideEntityManager();
			Account account = em.find(Account.class, accountNumber);
			em.getTransaction().begin();
			account.setAccountHolderName(accountDto.getAccountHolderName());
			account.setEmail(accountDto.getEmail());
			account.setAge(accountDto.getAge());
			em.getTransaction().commit();
			em.close();
			System.out.println(account);
		}else {
			System.out.println("No account found as mentioned.");
		}
	}

}
