package com.klef.ep.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Employee;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AdminServiceImpl {
	
	
	public String adminlogin(Admin a,String eid, String epwd) 
	  {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	      EntityManager entityManager = entityManagerFactory.createEntityManager();
	      
	      entityManager.getTransaction().begin();
	      Admin ad=entityManager.find(Admin.class,eid);
	      entityManager.getTransaction().commit();
	      
	      entityManager.close();
	      entityManagerFactory.close();
	      
	      return "Admin Logged In Successfully";
	  }
}
