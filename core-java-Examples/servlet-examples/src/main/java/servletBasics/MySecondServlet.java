package servletBasics;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MySecondServlet implements Servlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		out.println("<a href='welcome.html'>Homepage</a>");
		out.println("<h1>My second servlet page</h1>");
		out.println("<a href='firstServlet'>FirstServlet page</a>");
		out.println("</body></html>");
	}
	
	public void init(ServletConfig sc) {}
	public String getServletInfo() { return null; }
	public ServletConfig getServletConfig() { return null; }
	public void destroy() {}
}
