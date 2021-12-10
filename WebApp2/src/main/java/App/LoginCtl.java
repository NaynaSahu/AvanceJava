package App;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCtl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = request.getParameter("operation");
		if(s.equals("logout")) {
           HttpSession session = request.getSession();
           session.invalidate();
           response.sendRedirect("LoginView.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String user = request.getParameter("User");
		String pass = request.getParameter("Password");
	

		RegistrationBean bean = new RegistrationBean();
		RegistrationModel model = new RegistrationModel();

		 if (Validation.isNull(user)) {
			request.setAttribute("empty", "Please Enter UserName");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);

		} else if (Validation.isNull(pass)) {
			request.setAttribute("empty1", "Please Enter Password");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);

		}

		try {
			bean = model.Authentication (user, pass);
           //String fname = bean.getFname();
			
			if (bean != null) {
				String fname = bean.getFname();
				HttpSession session = request.getSession();
				session.setAttribute("bean", bean);
				session.setAttribute("pass", pass);
				session.setAttribute("fname", fname);
				//request.setAttribute("fname", bean.getFname());
				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("error", "Invalid UserName or Password");
				RequestDispatcher rd = request.getRequestDispatcher("/LoginView.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
