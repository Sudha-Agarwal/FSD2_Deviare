package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Classes.Employee;
import DAO.EmployeeDAO;

/**
 * Servlet implementation class viewServlet
 */
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		List<Employee> list = EmployeeDAO.getAllEmployeeCallable();
		
		for(Employee emp: list) {
			out.print("<p>" + emp.firstName + "</p>");		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		Employee e = EmployeeDAO.getEmployeeById(id);
		//System.out.println(e.firstName);
		
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		
		out.print("<p>" + e.firstName + "</p>");
		
		
		
		
	}

}
