package com.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EM_Utility {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("granuality");
	}
	
	public static EntityManager provideEntityManager(){
		return emf.createEntityManager();
	}
}	
