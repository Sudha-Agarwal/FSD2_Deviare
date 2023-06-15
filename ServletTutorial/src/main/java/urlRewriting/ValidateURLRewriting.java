package urlRewriting;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ValidateURLRewriting
 */

//@WebServlet("/urlRewriting/ValidateURLRewriting")
public class ValidateURLRewriting extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ValidateURLRewriting() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin")) {
			response.sendRedirect("ValidateURLRewritingSecond?user_name=" + username);
		}
	}

}
