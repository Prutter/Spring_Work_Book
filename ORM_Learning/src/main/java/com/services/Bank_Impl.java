package com.services;

import javax.persistence.EntityManager;

import com.entities.Account;
import com.utility.EM_Utility;

public class Bank_Impl implements Bank_Interface{

	@Override
	public boolean createAccount(Account account) {
		boolean isCreated = false;
		
		EntityManager em = EM_Utility.provideEntityManager();
		Account acc = em.find(Account.class, account.getAccountNumber());
		if(acc == null) {
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
			isCreated = true;
		}else {
			System.out.println("Account Number already exist with us.");
		}
		em.close();
		return isCreated;
	}

	@Override
	public boolean findAccount(Long accountNumber) {
		boolean isFound = false;
		
		EntityManager em = EM_Utility.provideEntityManager();
		Account acc = em.find(Account.class, accountNumber);
		if(acc != null) 
			isFound = true;
		
		em.close();
		return isFound;
	}

	@Override
	public boolean updateAccount(Account account) {
		boolean isUpdated = false;
		EntityManager em = EM_Utility.provideEntityManager();
		Account acc = em.find(Account.class, account.getAccountNumber());
		
		if(acc != null) {
			em.getTransaction().begin();
			em.merge(account);
			em.getTransaction().commit();
			em.close();
			isUpdated = true;
		}else {
			System.out.println("Account not found");
		}
		return isUpdated;
	}

	@Override
	public boolean deleteAccount(Long accountNumber) {
		boolean isDeleted = false;
		
		EntityManager em = EM_Utility.provideEntityManager();
		Account acc = em.find(Account.class, accountNumber);
		if(acc != null) {
			em.getTransaction().begin();
			em.remove(acc);
			em.getTransaction().commit();
			em.close();
			isDeleted = true;
		}else {
			System.out.println("Account not found");
		}
		return isDeleted;
	}

}
