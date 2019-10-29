package user_registration_j2ee.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_registration_j2ee.DAO.RegisterDAO;
import user_registration_j2ee.beans.User;
 


public class Registration_servlet extends HttpServlet{
	
	public Registration_servlet()
	{
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User user = new User();
			
			user.setFullName(fullname);
			user.setEmail(email);
			user.setUserName(username);
			user.setPassword(password);
			
			RegisterDAO rDAO = new RegisterDAO();
			
			String user_registered = rDAO.registerUser(user);
			
			if(user_registered.equals("Success"))
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			else
			{
				request.setAttribute("errMessage", user_registered);
				 request.getRequestDispatcher("/Register.jsp").forward(request, response);
			}
				
		}
	}


