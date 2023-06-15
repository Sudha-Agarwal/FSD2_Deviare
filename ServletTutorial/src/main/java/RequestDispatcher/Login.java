package RequestDispatcher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String password = request.getParameter("userPass");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(password.equals("admin")) {
			out.print("Correct");
			RequestDispatcher rd = request.getRequestDispatcher("/RequestDispatcher/WelcomeServlet");
			rd.forward(request, response);
		}
		else {
			out.print("Username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("/RequestDispatcher/index.html");
			rd.include(request,response);
			
		}
		
	}

}
