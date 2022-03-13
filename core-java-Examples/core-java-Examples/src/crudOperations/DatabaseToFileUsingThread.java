package crudOperations;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;

public class DatabaseToFileUsingThread implements Runnable {
	String employeeName;
	Integer employeeId;
	Integer employeeSalary;

	DatabaseToFileUsingThread() {
	}

	DatabaseToFileUsingThread(String name, Integer id, Integer salary) {
		employeeName = name;
		employeeId = id;
		employeeSalary = salary;
	}

	static Properties properties = new Properties();
	static FileInputStream propertiesInputStream;
	static FileOutputStream propertiesOutputStream;

	static {
		try {
			propertiesInputStream = new FileInputStream("application.properties");
			propertiesOutputStream = new FileOutputStream("application.properties", true);
			properties.load(propertiesInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\dbEmpdata\\" + employeeName + ".txt", true));
			String employeeData = "Name: " + employeeName + " Id: " + employeeId + " Salary: " + employeeSalary;
			writer.write(employeeData);
			writer.flush();
			writer.close();
			System.out.println("write success: " + Thread.currentThread().getName() + " " + employeeData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException, Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = DriverManager.getConnection(properties.getProperty("dbURL"),
				properties.getProperty("dbUserName"), properties.getProperty("dbPassword"));
		System.out.println("Connected to database");

		return connection;
	}

	public void createEmployeesFileUsingThreads() {

		String query = "SELECT * FROM employee";
		try {
			Connection connection = this.getConnection();

			Statement createStatement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet;
			resultSet = createStatement.executeQuery(query);

			resultSet.last();

			int totalEmployees = resultSet.getRow();

			Thread thread[] = new Thread[totalEmployees];

			resultSet.beforeFirst();
			int counter = 0;
			while (resultSet.next()) {
				Integer empId = resultSet.getInt("id");
				String empName = resultSet.getString("name");
				Integer empSalary = resultSet.getInt("salary");

				thread[counter] = new Thread(new DatabaseToFileUsingThread(empName, empId, empSalary));
				thread[counter].start();
				System.out.println(empId + " " + empName + " " + empSalary);
				counter++;
			}
			connection.close();

		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error: " + cnfe);
		} catch (SQLException sqle) {
			System.out.println("Error: " + sqle);
			sqle.printStackTrace();
		} catch (ArithmeticException ae) {
			System.out.println("Error: " + ae);
		} catch (InputMismatchException ime) {
			System.out.println("Error: " + ime);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public void createEmployeesFileUsingStream() {

		String query = "SELECT * FROM employee";
		try {
			Connection connection = this.getConnection();

			Statement createStatement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet;
			resultSet = createStatement.executeQuery(query);

//			resultSet.last();
//
//			int totalEmployees = resultSet.getRow();

			// Thread thread[] = new Thread[totalEmployees];

			List<Employee> employeeList = new ArrayList<>();
			resultSet.beforeFirst();
			int counter = 0;
			while (resultSet.next()) {
				Integer empId = resultSet.getInt("id");
				String empName = resultSet.getString("name");
				Integer empSalary = resultSet.getInt("salary");
				employeeList.add(new Employee(empId, empName, empSalary));
				// thread[counter] = new Thread(new DatabaseToFileUsingThread(empName, empId,
				// empSalary));
				// thread[counter].start();
				// System.out.println(empId + " " + empName + " " + empSalary);
				counter++;
			}
			synchronized (this) {
				employeeList.parallelStream().forEach(emp -> {
					try {
						BufferedWriter writer = new BufferedWriter(
								new FileWriter("d:\\dbEmpdata\\" + emp.getName() + ".txt", true));
						String employeeData = " Id: " + emp.getEmpId() + "Name: " + emp.getName() + " Salary: "
								+ emp.getSalary();
						writer.write(employeeData);
						writer.flush();
						writer.close();
						System.out.println("write success: " + Thread.currentThread().getName() + " " + employeeData);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
			connection.close();

		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error: " + cnfe);
		} catch (SQLException sqle) {
			System.out.println("Error: " + sqle);
			sqle.printStackTrace();
		} catch (ArithmeticException ae) {
			System.out.println("Error: " + ae);
		} catch (InputMismatchException ime) {
			System.out.println("Error: " + ime);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public static void main(String[] args) throws IOException {
		DatabaseToFileUsingThread obj = new DatabaseToFileUsingThread();
//		obj.createEmployeesFileUsingThreads();
		obj.createEmployeesFileUsingStream();
		/*
		 * properties.setProperty("dbPassword", "Chetu@123");
		 * properties.setProperty("mySqlDriver", "com.mysql.cj.jdbc.Driver");
		 * properties.setProperty("dbUserName", "root"); properties.setProperty("dbURL",
		 * "hetu@123jdbc:mysql://localhost:3306/project1");
		 * properties.setProperty("error", "Error: ");
		 * properties.store(propertiesOutputStream, null);
		 * System.out.println(properties.getProperty("dbUserName"));
		 * propertiesOutputStream.close();
		 */

//		Thread thread1 = new Thread(new DatabaseToFileUsingThread());
//		Thread thread2 = new Thread(new DatabaseToFileUsingThread());
//		thread1.start();
//		thread2.start();
//		DatabaseToFileUsingThread obj = new DatabaseToFileUsingThread();
//		obj.printEmployee();
	}

}
