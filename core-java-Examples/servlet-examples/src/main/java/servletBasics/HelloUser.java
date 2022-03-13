package servletBasics;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloUser extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();

		out.println("<a href='welcome.html'>Homepage</a>");
		String name = req.getParameter("name");
		out.println("Hello " + name);
	}


}
