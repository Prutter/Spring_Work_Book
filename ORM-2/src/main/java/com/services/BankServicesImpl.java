package com.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entities.Account;
import com.entities.AccountDTO;
import com.utility.EM_Utility;

public class BankServicesImpl implements BankServices{

	@Override
	public boolean findAccount(Integer accountNumber) {
		boolean isfound = false;
		EntityManager em = EM_Utility.provideEntityManager();
		Account acc = em.find(Account.class, accountNumber);
		if(acc != null)
			isfound = true;
		em.close();
		return isfound;
	}

	@Override
	public void createAccount(Account account) {
		EntityManager em = EM_Utility.provideEntityManager();
		Query q = em.createQuery("Select e from Account e");
		List<Account> list = q.getResultList();
		boolean isPresent = false;
		for(Account a : list) {
			if(a.getAadharcard() == account.getAadharcard() || 
					a.getPancard().equals(account.getPancard()) || 
					a.getAccountNumber() == account.getAccountNumber() ||
					a.getEmail().equals(account.getEmail())) {
				isPresent = true;
				break;
			}		
		}
		if(isPresent) {
			System.out.println("Similar details already exist");
		}else {
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
			em.close();
			System.out.println("Account created successfully.");
		}
	}

	@Override
	public void creditAmount(Integer accountnumber, Double amount) {
		if(findAccount(accountnumber)) {
			EntityManager em = EM_Utility.provideEntityManager();
			em.getTransaction().begin();
			Account acc = em.find(Account.class, accountnumber);
			acc.setBalance(acc.getBalance()+ amount);
			System.out.println("Amount is credited. Now it is "+ acc.getBalance());
			em.getTransaction().commit();
			em.clear();
		}else {
			System.out.println("We do not find your account");
		}
	}
	
	

	@Override
	public void withdrawAmount(Integer accountNumber, String email, Double amount) {
		if(findAccount(accountNumber)) {
			EntityManager em = EM_Utility.provideEntityManager();
			em.getTransaction().begin();
			Account acc = em.find(Account.class, accountNumber);
			if(acc.getEmail().equals(email)){
				acc.setBalance(acc.getBalance() - amount);
				System.out.println("Amount is debited. Now it is "+ acc.getBalance());
			}else {
				System.out.println("Please provide correct credentails.");
			}
			em.getTransaction().commit();
			em.clear();
		}else {
			System.out.println("We do not find your account");
		}
	}

	@Override
	public void fetchAccount(Integer accountNumber, String email, String name) {
		if(findAccount(accountNumber)) {
			EntityManager em = EM_Utility.provideEntityManager();
			em.getTransaction().begin();
			Account acc = em.find(Account.class, accountNumber);
			if(acc.getEmail().equals(email) && acc.getAccountHolderName().equals(name)){
				System.out.println(acc);
			}else {
				System.out.println("Please provide correct credentails.");
			}
			em.getTransaction().commit();
			em.clear();
		}else {
			System.out.println("We do not find your account");
		}
	}
	
	@Override
	public void balanceAmount(Integer accountnumber, String email) {
		if(findAccount(accountnumber)) {
			EntityManager em = EM_Utility.provideEntityManager();
			em.getTransaction().begin();
			Account acc = em.find(Account.class, accountnumber);
			if(acc.getEmail().equals(email))
				System.out.println("Your account balance is "+ acc.getBalance());
			else
				System.out.println("Mention correct email.");
			em.getTransaction().commit();
			em.clear();
		}else {
			System.out.println("We do not find your account");
		}
	}

	@Override
	public void updateAccount(Integer accountnumber, AccountDTO accountDto) {
		if(findAccount(accountnumber)) {
			EntityManager em = EM_Utility.provideEntityManager();
			em.getTransaction().begin();
			Account acc = em.find(Account.class, accountnumber);
			acc.setAge(accountDto.getAge());
			acc.setEmail(accountDto.getEmail());
			acc.setAccountHolderName(accountDto.getAccountHolderName());
			System.out.println("Account details are updated.");
			em.getTransaction().commit();
			em.clear();
		}else {
			System.out.println("We do not find your account");
		}
	}
}
