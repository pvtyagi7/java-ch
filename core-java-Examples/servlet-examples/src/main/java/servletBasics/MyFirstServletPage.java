package servletBasics;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyFirstServletPage implements Servlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println("<html><body>");
		out.println("<a href='welcome.html'>Homepage</a>");
		out.println("<h1>My First Servlet page</h1>");
		out.println("<a href='secondServlet'>SecondServlet page</a>");

		out.println("<a href='generic1'>GenericServlet page</a>");
		out.println("</body></html>");
	}
	
	public void init(ServletConfig sc) {}
	public void destroy() {}
	public ServletConfig getServletConfig() {
		return null;
	}
	public String getServletInfo() {
		return null;
	}
}
