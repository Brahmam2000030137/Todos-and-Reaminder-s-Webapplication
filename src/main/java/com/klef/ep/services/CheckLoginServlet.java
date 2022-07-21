package com.klef.ep.services;

import java.io.*;
import javax.ejb.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.klef.ep.models.Client;

@WebServlet("/checkuser")
public class CheckLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@EJB(lookup = "java:global/ToDo/ClientServiceImpl!com.klef.ep.services.ClientService")
	ClientService userService;
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      String uname=request.getParameter("uname");
      String pwd=request.getParameter("pwd");
      
      Client u = userService.userLogin(uname, pwd);
      
      if(u!=null)
      {
    	  out.println("Login Success");
      }
      else
      {
    	  out.println("Login Failed");
      }
  }
}