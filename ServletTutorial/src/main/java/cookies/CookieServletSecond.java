package cookies;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServletSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CookieServletSecond() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		Cookie ck[] = request.getCookies();
		String username = null;
		
		if(ck!= null) {
			for(Cookie cookie:ck) {
				if(cookie.getName().equals("username")) {
					username = cookie.getValue();					
					out.print("Hello " + username + "<br>");						
					out.print("<a href='LogoutServlet'>Logout</a>");				
				}
			}
		}
		
		if(username == null) {
			out.print("Your session has timed out");
			RequestDispatcher rd = request.getRequestDispatcher("/cookies/index.html");
			rd.include(request, response);
			
		}
		
		
		
	}

}
