package servletBasics;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginUser extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<a href='welcome.html'>Homepage</a>");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if(email.equals("a@gmail.com") && password.equals("123")) {
			out.println("Welcome  " + email);
		}
		else
			out.print("Invalid credenetials.");
	}
}
