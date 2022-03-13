package servletBasics;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GenericDemo1 extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html><body>");
		out.println("<a href='welcome.html'>Homepage</a>");
		out.println("<a href='firstServlet'>gotoFirstPage</a>");
			out.println("<a href='secondServlet'>SecondServlet page</a>");
		out.println("</body></html>");
	}
}
