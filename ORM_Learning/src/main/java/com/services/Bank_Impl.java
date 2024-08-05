package com.services;

import javax.persistence.EntityManager;

import com.entities.Account;
import com.utility.EM_Utility;

public class Bank_Impl implements Bank_Interface{

	@Override
	public void createAccount(Account account) {
		EntityManager em = EM_Utility.provideEntityManager();
		try {
			
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
			System.out.println("Account is created");
			
		}catch (Exception e) {
			System.out.println("Similar details already present.");
		}finally {
			em.close();
		}
	}

	@Override
	public boolean findAccount(Integer accountNumber) {
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
	public boolean deleteAccount(Integer accountNumber) {
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



	@Override
	public Account fetchDetails(Integer accountNumber) {
		EntityManager em = EM_Utility.provideEntityManager();
		Account acc = em.find(Account.class, accountNumber);
		em.close();
		if(acc != null) {
			return acc;
		}else {
			System.out.println("Account not found");
			return null;
		}
	}

}
