package com.klef.ep.services;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Employee;

public interface AdminService 
{
	public String adminlogin(Admin a,String eid, String epwd);
		
}
