package com.usecases;

import javax.persistence.EntityManager;

import com.entities.Address;
import com.entities.Bank;
import com.entities.Branch;
import com.utility.EM_Utility;

public class Main1 {
	public static void main(String[] args) {
		
//		SBI bank has three branches
		Bank sbi_bank = new Bank();
		sbi_bank.setBankName("SBI");

		Branch sbi_A = new Branch();
		sbi_A.setBranchName("Budh-Vihar");
		
		Address sbi_A_Budh_main = new Address();
		sbi_A_Budh_main.setOfficeNumber(1);
		sbi_A_Budh_main.setBuildingName("Office-1");
		sbi_A_Budh_main.setRegion("Budh-Vihar");
		sbi_A_Budh_main.setPinCode(110081);
		
		Address sbi_A_Budh_loan = new Address();
		sbi_A_Budh_loan.setOfficeNumber(2);
		sbi_A_Budh_loan.setBuildingName("Office-2");
		sbi_A_Budh_loan.setRegion("Budh-Vihar");
		sbi_A_Budh_loan.setPinCode(110082);
		
		sbi_A.setMain(sbi_A_Budh_main);
		sbi_A.setLoan(sbi_A_Budh_loan);
		
		
		Branch sbi_B = new Branch();
		sbi_B.setBranchName("Rama-Vihar");
		
		Address sbi_B_Rama_main = new Address();
		sbi_B_Rama_main.setOfficeNumber(3);
		sbi_B_Rama_main.setBuildingName("Office-3");
		sbi_B_Rama_main.setRegion("Rama-Vihar");
		sbi_B_Rama_main.setPinCode(110083);
		
		Address sbi_B_Rama_loan = new Address();
		sbi_B_Rama_loan.setOfficeNumber(4);
		sbi_B_Rama_loan.setBuildingName("Office-4");
		sbi_B_Rama_loan.setRegion("Rama-Vihar");
		sbi_B_Rama_loan.setPinCode(110084);
		
		sbi_B.setMain(sbi_B_Rama_main);
		sbi_B.setLoan(sbi_B_Rama_loan);
		
		
		Branch sbi_C = new Branch();
		sbi_C.setBranchName("Krishna-Vihar");
		
		Address sbi_C_Krishna_main = new Address();
		sbi_C_Krishna_main.setOfficeNumber(5);
		sbi_C_Krishna_main.setBuildingName("Office-5");
		sbi_C_Krishna_main.setRegion("Krishna-Vihar");
		sbi_C_Krishna_main.setPinCode(110085);
		
		Address sbi_C_Krishna_loan = new Address();
		sbi_C_Krishna_loan.setOfficeNumber(6);
		sbi_C_Krishna_loan.setBuildingName("Office-6");
		sbi_C_Krishna_loan.setRegion("Krishna-Vihar");
		sbi_C_Krishna_loan.setPinCode(110086);
		
		sbi_C.setMain(sbi_C_Krishna_main);
		sbi_C.setLoan(sbi_C_Krishna_loan);
		
		
//		AXIS bank has three branches		
		Bank axis_bank = new Bank();
		axis_bank.setBankName("AXIS");
		
		Branch axis_A = new Branch();
		axis_A.setBranchName("Budh-Vihar");
		
		Address axis_A_Budh_main = new Address();
		axis_A_Budh_main.setOfficeNumber(7);
		axis_A_Budh_main.setBuildingName("Office-7");
		axis_A_Budh_main.setRegion("Budh-Vihar");
		axis_A_Budh_main.setPinCode(110081);
		
		Address axis_A_Budh_loan = new Address();
		axis_A_Budh_loan.setOfficeNumber(8);
		axis_A_Budh_loan.setBuildingName("Office-8");
		axis_A_Budh_loan.setRegion("Budh-Vihar");
		axis_A_Budh_loan.setPinCode(110082);
		
		axis_A.setMain(axis_A_Budh_main);
		axis_A.setLoan(axis_A_Budh_loan);
		
		Branch axis_B = new Branch();
		axis_B.setBranchName("Rama-Vihar");
		Address axis_B_Rama_main = new Address();
		axis_B_Rama_main.setOfficeNumber(9);
		axis_B_Rama_main.setBuildingName("Office-9");
		axis_B_Rama_main.setRegion("Rama-Vihar");
		axis_B_Rama_main.setPinCode(110083);
		
		Address axis_B_Rama_loan = new Address();
		axis_B_Rama_loan.setOfficeNumber(10);
		axis_B_Rama_loan.setBuildingName("Office-10");
		axis_B_Rama_loan.setRegion("Rama-Vihar");
		axis_B_Rama_loan.setPinCode(110084);
		
		axis_B.setMain(axis_B_Rama_main);
		axis_A.setLoan(axis_B_Rama_loan);
		
		Branch axis_C = new Branch();
		axis_C.setBranchName("Krishna-Vihar");
		Address axis_C_Krishna_main = new Address();
		axis_C_Krishna_main.setOfficeNumber(11);
		axis_C_Krishna_main.setBuildingName("Office-11");
		axis_C_Krishna_main.setRegion("Krishna-Vihar");
		axis_C_Krishna_main.setPinCode(110085);
		
		Address axis_C_Krishna_loan = new Address();
		axis_C_Krishna_loan.setOfficeNumber(12);
		axis_C_Krishna_loan.setBuildingName("Office-12");
		axis_C_Krishna_loan.setRegion("Krishna-Vihar");
		axis_C_Krishna_loan.setPinCode(110086);
		
		axis_C.setMain(axis_C_Krishna_main);
		axis_C.setLoan(axis_C_Krishna_loan);
		
		
		
//		Completing the actual objects by adding branches in it. 
		sbi_bank.getBranches().add(sbi_A);
		sbi_bank.getBranches().add(sbi_B);
		sbi_bank.getBranches().add(sbi_C);
		
		axis_bank.getBranches().add(axis_A);
		axis_bank.getBranches().add(axis_B);
		axis_bank.getBranches().add(axis_C);
		
		
		EntityManager em = EM_Utility.provideEntityManager();
		em.getTransaction().begin();
		em.persist(sbi_A);
		em.persist(sbi_B);
		em.persist(sbi_C);
		em.persist(sbi_bank);
		
		em.persist(axis_A);
		em.persist(axis_B);
		em.persist(axis_C);
		em.persist(axis_bank);
		
		em.getTransaction().commit();
		em.close();
		System.out.println("Task-Done");
	}
}
