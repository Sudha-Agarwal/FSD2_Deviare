

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletContextAndConfig
 */
public class ServletContextAndConfig extends HttpServlet {
	private ServletConfig servletConfig;
	private ServletContext servletContext;
	
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Get ServletConfig
		this.servletConfig = getServletConfig();
		String servletName = servletConfig.getServletName();		
		System.out.println("Servlet Name " + servletName);		
		
		String initParam = servletConfig.getInitParameter("param1");
		System.out.println("Servlet Init parameter value " + initParam);
		
		
		this.servletContext = servletConfig.getServletContext();
		String dbName = servletContext.getInitParameter("dname");
		 System.out.println("Web application Context Parameter DB Name " + dbName);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
