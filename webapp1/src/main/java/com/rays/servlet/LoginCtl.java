package com.rays.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginCtl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String Email = request.getParameter("email");
	String User = request.getParameter("Username");
	String Password = request.getParameter("Password");
	
	UserModel m = new UserModel();
	UserBean bean=new UserBean();
	try {
		bean = m.Authentication(Email, User, Password);
		if(bean!=null) {
			/*
			 * String fn = bean.getFname(); request.setAttribute("fna", fn);
			 */
			RequestDispatcher rd = request.getRequestDispatcher("/WelcomeCtl");
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "Invalid email or username or password");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}

}
