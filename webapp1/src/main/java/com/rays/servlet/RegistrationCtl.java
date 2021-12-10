package com.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.standard.PrinterInfo;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationCtl")
public class RegistrationCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationCtl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String Gender = request.getParameter("Gender");
		String Email = request.getParameter("Email");
		String User = request.getParameter("User");
		String Password = request.getParameter("Password");

		UserBean bean = new UserBean();
		bean.setFname(fname);
		bean.setLname(lname);
		bean.setGender(Gender);
		bean.setEmail(Email);
		bean.setUser(User);
		bean.setPassword(Password);
		if (fname.isEmpty() && lname.isEmpty() && Gender == null && Email.isEmpty() && User.isEmpty()
				&& Password.isEmpty()) {
			request.setAttribute("empty", "Please enter First name");
			request.setAttribute("empty1", "Please enter last name");
			request.setAttribute("empty2", "Please select Gender");
			request.setAttribute("empty3", "Please enter Email");
			request.setAttribute("empty4", "Please enter User Name");
			request.setAttribute("empty5", "Please enter password");
			RequestDispatcher rd1 = request.getRequestDispatcher("Registration.jsp");
			rd1.forward(request, response);

		}

		else if (fname.isEmpty()) {
			request.setAttribute("empty", "Please enter First name");
			RequestDispatcher rd1 = request.getRequestDispatcher("Registration.jsp");
			rd1.forward(request, response);

		} else if (lname.isEmpty()) {
			request.setAttribute("empty1", "Please enter last name");
			RequestDispatcher rd1 = request.getRequestDispatcher("Registration.jsp");
			rd1.forward(request, response);

		} else if (Gender == null) {
			request.setAttribute("empty2", "Please select Gender");
			RequestDispatcher rd1 = request.getRequestDispatcher("Registration.jsp");
			rd1.forward(request, response);

		} else if (Email.isEmpty()) {
			request.setAttribute("empty3", "Please enter Email");
			RequestDispatcher rd1 = request.getRequestDispatcher("Registration.jsp");
			rd1.forward(request, response);

		} else if (User.isEmpty()) {
			request.setAttribute("empty4", "Please enter User Name");
			RequestDispatcher rd1 = request.getRequestDispatcher("Registration.jsp");
			rd1.forward(request, response);

		} else if (Password.isEmpty()) {
			request.setAttribute("empty5", "Please enter password");
			RequestDispatcher rd1 = request.getRequestDispatcher("Registration.jsp");
			rd1.forward(request, response);

		}

		else {
			UserModel u = new UserModel();
			try {
				u.add(bean);
			} catch (Exception e) {

			}
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);

		}

	}

}
