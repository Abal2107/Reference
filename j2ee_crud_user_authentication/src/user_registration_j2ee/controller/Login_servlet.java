package user_registration_j2ee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_registration_j2ee.DAO.LoginDAO;

public class Login_servlet extends HttpServlet{

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginDAO logindao = new LoginDAO();
		String getpass = logindao.checkpass(username);
		
		if(getpass.equals(password))
		{	request.setAttribute("Message", "Welcome");
		 request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("Message", "Wrong password");
			 request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		
	}
	
	
}
