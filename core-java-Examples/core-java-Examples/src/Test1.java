/*
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.SQLException; import
 * java.util.Timer; import java.util.TimerTask;
 * 
 * public class Test1 {
 * 
 * public static void main(String[] args) { Timer timer = new Timer();
 * timer.schedule(new TimerTask() {
 * 
 * @Override public void run() { System.out.println("Hiii"); } }, 0,
 * 1000);//wait 0 ms before doing the action and do it evry 1000ms (1second) //
 * // timer.cancel();//stop the timer
 * 
 * }
 * 
 * }
 * 
 * 
 * public static void insertToDatabase() { try {
 * Class.forName("com.mysql.cj.jdbc.Driver");
 * System.out.println("Driver Loaded"); Connection con =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root",
 * "Chetu@123"); System.out.println("Connected..."); PreparedStatement pst =
 * con.prepareStatement("INSERT INTO employee(id, name, salary) VALUES(?, ?, ?)"
 * );
 * 
 * pst.setInt(1, 10); pst.setString(2, "Rohit"); pst.setInt(3, 5000);
 * 
 * pst.executeUpdate(); con.close(); System.out.println("Connection closed.");
 * 
 * } catch (ClassNotFoundException e) { System.out.println("Error: " + e); }
 * catch (SQLException e) { System.out.println("Error: " + e); } }
 * 
 * //////////////////////below code is working/////////////// import java.sql.*;
 * import java.io.*;
 * 
 * public class FileToDatabase { public static void main(String[] args) { try {
 * Class.forName("com.mysql.cj.jdbc.Driver");
 * System.out.println("Driver Loaded"); Connection con =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root",
 * "Chetu@123"); PreparedStatement pst = null;
 * 
 * BufferedReader br = new BufferedReader(new FileReader("d://fileToDb.txt"));
 * String line = br.readLine();
 * 
 * while (line != null) { pst =
 * con.prepareStatement("INSERT INTO employee(id, name, salary) VALUES(?, ?, ?)"
 * );
 * 
 * String[] data = line.split(",", 3); pst.setInt(1, Integer.parseInt(data[0]));
 * pst.setString(2, data[1]); pst.setInt(3, Integer.parseInt(data[2]));
 * 
 * line = br.readLine(); pst.executeUpdate();
 * 
 * }
 * 
 * br.close(); con.close(); System.out.println("Connection closed.");
 * 
 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
 * e) { e.printStackTrace(); } catch (ClassNotFoundException e) {
 * System.out.println("Error: " + e); } catch (SQLException e) {
 * System.out.println("Error: " + e); } catch (NumberFormatException e) {
 * System.out.println("Error: " + e); }
 * 
 * }
 * 
 * } ///////////////
 */
