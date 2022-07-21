package com.klef.ep.models;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.klef.ep.services.AdminService;
import com.klef.ep.services.EmployeeService;

@ManagedBean(name = "adminBean",eager = true)
public class AdminBean 
{
	private String username;
	private String password;
	private String response;
	private String taskstatus;
	
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	@EJB(lookup = "java:global/ToDo/AdminServiceImpl!com.klef.ep.services.AdminServiceImpl")
	AdminService adminService;
	Admin a = new Admin();
	public void adminlogin(){
		{
			try
			{
				//response=AdminService.adminlogin(a,username,password);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	
}
