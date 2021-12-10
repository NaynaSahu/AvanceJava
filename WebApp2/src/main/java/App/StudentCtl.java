package App;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentCtl
 */
@WebServlet("/StudentCtl")
public class StudentCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String roll = request.getParameter("roll");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String session = request.getParameter("session");
		String op = request.getParameter("operation");
		if("Add".equalsIgnoreCase(op)) {
		
		StudentBean bean = new StudentBean();
		bean.setRollNo(roll);
		bean.setFirstName(fname);
		bean.setLastName(lname);
		bean.setSession(session);
		
		StudentModel model = new StudentModel();
		try {
			
			model.add(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}

}
