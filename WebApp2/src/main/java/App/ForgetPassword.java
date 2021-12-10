package App;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgetPassword() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		
		RegistrationBean bean = new RegistrationBean();
		RegistrationModel model = new RegistrationModel();
		
		try {
			bean = model.ForgetPassword(email);
			if(bean !=null) {
				request.setAttribute("pass", bean.getPass());
				RequestDispatcher rd = request.getRequestDispatcher("ForgetPassword.jsp");
				rd.forward(request, response);
				
			}else {
				
				request.setAttribute("NotFound", "User Not Found");
				RequestDispatcher rd = request.getRequestDispatcher("ForgetPassword.jsp");
				rd.forward(request, response);
			}
				
				
		
			}catch (Exception e) {
				
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		
		

		
