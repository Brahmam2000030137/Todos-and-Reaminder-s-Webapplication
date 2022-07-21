package com.klef.ep.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Client;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientServiceImpl implements ClientService
{

	@Override
	public String userRegistration(Client u) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    entityManager.persist(u);
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	 
	    
	    return "Registration Success";
	}

	@Override
	public Client userLogin(String uname, String pwd) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Query qry=entityManager.createQuery("select u from User u where username=? and  password=?");
	    qry.setParameter(1, uname);
	    qry.setParameter(2, pwd);
	    
	    Client u = null;
	    
	    if (qry.getResultList().size()==1) 
	    {
	    	u = (Client) qry.getSingleResult();
	    }
	    
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return u;
	}

}
