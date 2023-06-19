package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Classes.Employee;
import DAO.EmployeeDAO;

public class saveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public saveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		
		emp.lastName = lastName;
		emp.userName = userName;
		emp.password = password;
		emp.address = address;
		emp.contact = contact;
		
		int result = EmployeeDAO.registerEmployee(emp);
		
		PrintWriter out = response.getWriter();
		
		if(result!=0) {
			out.print("Record inserted successfully");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);			
		}
		else {
			out.print("Record insertion Error");
			RequestDispatcher rd = request.getRequestDispatcher("employeeregister.html");
			rd.include(request, response);	
			
		}
		
		
		
		
		
		
		
	}

}
