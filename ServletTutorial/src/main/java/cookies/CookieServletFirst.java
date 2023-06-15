package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServletFirst extends HttpServlet {
    public CookieServletFirst() {
        super();       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//check the username and password
		if(username.equals("admin") && password.equals("admin")) {
			//create a new cookie with the username
			
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(30 * 24 * 60 * 60);//30 days
			
			response.addCookie(cookie);
			response.sendRedirect("CookieServletSecond");
			
		}
	}

}
