package com.klef.ep.services;

import javax.ejb.Remote;

import com.klef.ep.models.Client;

@Remote
public interface ClientService 
{
	public String userRegistration(Client u);
	public Client userLogin(String uname,String pwd);
}
