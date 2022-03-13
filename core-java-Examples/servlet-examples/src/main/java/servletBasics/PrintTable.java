package servletBasics;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PrintTable extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Integer num = Integer.parseInt(req.getParameter("number"));
		out.println("<html><body>");

		out.println("<a href='welcome.html'>Homepage</a>");
		for(int i=1; i<=10; i++)
			out.println("<h3>" + num + " * " + i + " = " + (num * i) +  "</h3>");
		out.println("</body></html>");
	}
}
