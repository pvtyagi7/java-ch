package cafeProject;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;

public class AddCafe extends HttpServlet {
	static Connection connection;
	static ArrayList<Cafe> cafes = new ArrayList<>();

	public static void startConnection() {
//		String url = "jdbc:mysql://localhost:3306/project1";
		String url = "jdbc:mysql://localhost:3306/newdatabase";
		String userName = "root";
		String password = "";//"Chetu@123";
		String mysqlDriver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(mysqlDriver);
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Cafe> getAllCafes() throws SQLException, IOException, Exception {
		String sql = "SELECT * FROM cafes";
		
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			Integer cafeId = rs.getInt("id");
			String cafeName = rs.getString("Name");
			String cafeAddress = rs.getString("address");
			cafes.add(new Cafe(cafeId, cafeName, cafeAddress));
		}
 		return cafes;
		
	}
	public void createTable() {

//		String sql = "CREATE TABLE cafes(id int, name varchar(20), address varchar(20))";
		//String sql = "INSERT INTO cafes(name, address) VALUES(?,?)";
		
	//	Statement st = connection.createStatement();
	}

	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {

//			String sql = "CREATE TABLE cafes(id int, name varchar(20), address varchar(20))";
			String sql = "INSERT INTO cafes(name, address) VALUES(?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			String cafeName = req.getParameter("cafeName");
			String cafeAddress = req.getParameter("cafeAddress");
			pst.setString(1, cafeName);
			pst.setString(2, cafeAddress);
			pst.executeUpdate();
			
			System.out.println(cafeName + " " + cafeAddress);
			
			cafes = getAllCafes();
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();

			out.println("printed");
			req.setAttribute("response", "Added success");
			req.setAttribute("cafes", cafes);
			req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
		startConnection();
	}
	public void destroy() {

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
	}

}
