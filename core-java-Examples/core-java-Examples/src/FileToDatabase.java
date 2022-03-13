import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class FileToDatabase {

	public void connectToDatabase() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
	}

	public BufferedReader getFileDataByBufferedReader(String fileName) throws FileNotFoundException {
		return new BufferedReader(new FileReader(fileName));
	}

	public Connection getDatabaseConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Chetu@123");
	}

	public void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}

	public void setTimer(long timeToRepeatInMiliseconds) {
		FileToDatabase fileToDatabase = new FileToDatabase();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Connection connection;
				try {
					connection = getDatabaseConnection();
					PreparedStatement pst = null;

					BufferedReader br = fileToDatabase.getFileDataByBufferedReader("d://fileToDb.txt");
					String line = br.readLine();

					while (line != null) {
						pst = connection.prepareStatement("INSERT INTO employee(id, name, salary) VALUES(?, ?, ?)");

						String[] data = line.split(",", 3);
						pst.setInt(1, Integer.parseInt(data[0]));
						pst.setString(2, data[1]);
						pst.setInt(3, Integer.parseInt(data[2]));

						line = br.readLine();
						pst.executeUpdate();
						System.out.println("Data inserted");
					}
					br.close();
					fileToDatabase.closeConnection(connection);
				} catch (FileNotFoundException fileNotFoundException) {
					System.out.println("Error: " + fileNotFoundException);
				} catch (SQLException sQLException) {
					System.out.println("Error: " + sQLException);
				} catch (IOException iOException) {
					System.out.println("Error: " + iOException);
				} catch (Exception exception) {
					System.out.println("Error: " + exception);
				}

			}
		}, 0, timeToRepeatInMiliseconds);// wait 0 ms before doing the action and do it evry 1000ms (1second)

	}

	public void copyData() {
		try {
			this.connectToDatabase();
			// BufferedReader br = new BufferedReader(new FileReader("d://fileToDb.txt"));
			this.setTimer(1);

			System.out.println("Connection closed.");

		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("Error: " + classNotFoundException);
		} catch (NumberFormatException numberFormatException) {
			System.out.println("Error: " + numberFormatException);
		} catch (Exception exception) {
			System.out.println("Error: " + exception);
		}

	}

	public static void main(String[] args) {
		FileToDatabase fileToDatabase = new FileToDatabase();
		fileToDatabase.copyData();
	}

}
