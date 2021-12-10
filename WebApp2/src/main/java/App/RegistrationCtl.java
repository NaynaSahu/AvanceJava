package App;

import java.io.IOException;

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
		response.sendRedirect("Registration.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("operation");
		RegistrationBean bean = new RegistrationBean();
		RegistrationModel model = new RegistrationModel();

		if ("Reset".equalsIgnoreCase(op)) {

			response.sendRedirect("Registration.jsp");
		} else {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String user = request.getParameter("User");
			String email = request.getParameter("Email");
			String pass = request.getParameter("Password");
			String dob = request.getParameter("dob");
			String gender = request.getParameter("Gender");

			bean.setDob(dob);
			bean.setEmail(email);
			bean.setFname(fname);
			bean.setLname(lname);
			bean.setGender(gender);
			bean.setPass(pass);
			bean.setUsername(user);
			boolean pass2 = true;
			// Null Validation
			// FNAME
			if (Validation.isNull(fname)) {
				request.setAttribute("empty", "Kindly Enter First Name");
				pass2 = false;

			} else if (!Validation.isName(fname)) {
				request.setAttribute("reg2", "Please enter FirstName with only alphabets");
				pass2 = false;

			}
			// LNAME
			if (Validation.isNull(lname)) {
				request.setAttribute("empty1", "Kindly Enter Last Name");
				pass2 = false;
			} else if (!Validation.isName(lname)) {
				request.setAttribute("reg3", "Please enter LastName with only alphabets");
				pass2 = false;
			}
			// USER
			if (Validation.isNull(user)) {
				request.setAttribute("empty2", "Kindly Enter UserName");
				pass2 = false;

			} else if (!Validation.isName(user)) {
				request.setAttribute("reg4", "Please enter UserName with only alphabets");
				pass2 = false;
			}
			// EMAIL
			if (Validation.isNull(email)) {
				request.setAttribute("empty3", "Kindly Enter Email");
				pass2 = false;

			} else if (!Validation.isEmail(email)) {
				request.setAttribute("Reg5", "Please enter Email with only alphabets");
				pass2 = false;

			}
			// PASS
			if (Validation.isNull(pass)) {
				request.setAttribute("empty4", "Kindly Enter Password");
				pass2 = false;

			} else if (!Validation.isPass(pass)) {
				request.setAttribute("Reg1", "Please enter proper formet including special character , numbers.");
				pass2 = false;

			}
			// DOB
			if (Validation.isNull(dob)) {
				request.setAttribute("empty5", "Kindly Select Date Of Birth");
				pass2 = false;

			}
			// GENDER
			if (Validation.isNull(gender)) {
				request.setAttribute("empty6", "Kindly Select Gender");
				pass2 = false;
			}

			// Regex
			/*
			 * String fname1 = "^[a-zA-Z_-]+$"; if (fname != null) { if
			 * (!fname.matches(fname1)) { System.out.println("HERE 2");
			 * request.setAttribute("reg2", "Please enter FirstName with only alphabets");
			 * RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			 * rd.forward(request, response);
			 * 
			 * } }
			 * 
			 * String pass1 =
			 * "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$"; if
			 * (pass != null) {
			 * 
			 * if (!pass.matches(pass1)) {
			 * 
			 * request.setAttribute("Reg1",
			 * "Please enter proper formet including special character , numbers.");
			 * RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			 * rd.forward(request, response);
			 * 
			 * } }
			 * 
			 * String lname1 = "^[^-\\s][\\p{L} .']+$"; if (lname != null) { if
			 * (!lname.matches(lname1)) { request.setAttribute("Reg3",
			 * "Please enter LastName with only alphabets"); RequestDispatcher rd =
			 * request.getRequestDispatcher("Registration.jsp"); rd.forward(request,
			 * response);
			 * 
			 * } } String User1 = "^[^-\\s][\\p{L} .']+$"; if (user != null) { if
			 * (!user.matches(User1)) { request.setAttribute("Reg4",
			 * "Please enter Valid UserName with only alphabets"); RequestDispatcher rd =
			 * request.getRequestDispatcher("Registration.jsp"); rd.forward(request,
			 * response);
			 * 
			 * } } String email1 =
			 * "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			 * if (email != null) { if (!email.matches(email1)) {
			 * request.setAttribute("Reg5", "Please enter Email with only alphabets");
			 * RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			 * rd.forward(request, response);
			 * 
			 * } }
			 */
			RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			rd.forward(request, response);
			if (pass2 == true) {
				try {

					model.add(bean);

					request.setAttribute("success", "Successfully Registered");
					RequestDispatcher rd1 = request.getRequestDispatcher("Registration.jsp");
					rd1.forward(request, response);

				} catch (Exception e) {

					e.printStackTrace();
				}

			}

		}
	}
}
