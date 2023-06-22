package tagLib;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;


//Tag handler Class
public class CustomTag extends SimpleTagSupport{
	public void doTag() throws IOException, JspException {
		//Get the jspWriter to write content to the response
		JspWriter out = getJspContext().getOut();
		//performs custom tag logic
		out.println("This is our first custom tag");
		
	}

}
