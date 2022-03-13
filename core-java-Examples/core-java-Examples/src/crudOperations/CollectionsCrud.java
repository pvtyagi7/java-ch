package crudOperations;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.protocol.ResultsetRow;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Statement;

public class CollectionsCrud {

	static Properties properties = new Properties();

	private String url = "jdbc:mysql://localhost:3306/project1";
	private String userName = "root";
	private String userPassword = "Chetu@123";

	Map<Integer, Employee> employeeMap = new HashMap<>();

	static Scanner input = new Scanner(System.in);

	public String saveDataIntoDatabase(Map<?, ?> item) {

		return "Data saved.";
	}

	public void hashMapDemo() {

	}

	public Connection getConnection() throws ClassNotFoundException, SQLException, Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = DriverManager.getConnection(url, userName, userPassword);
		System.out.println("Connected to database");

		return connection;
	}

	public String insertEmployee() {

		System.out.print("Enter employee id: ");
		int employeeId = input.nextInt();

		System.out.print("\nEnter employee name: ");
		String employeeName = input.next();

		System.out.print("\nEnter employee salary: ");
		int employeeSalary = input.nextInt();

		String query = "INSERT INTO employee(id, name, salary) VALUES(?, ?, ?)";
		int rowCount = 0;
		try {
			Connection connection = this.getConnection();

			PreparedStatement prepareStatement = connection.prepareStatement(query);
			System.out.println("Statement object created");

			prepareStatement.setInt(1, employeeId);
			prepareStatement.setString(2, employeeName);
			prepareStatement.setDouble(3, employeeSalary);

			prepareStatement.executeUpdate();
			System.out.println("Employee Added");
			connection.close();

		} catch (ClassNotFoundException cnfe) {
			System.out.println(getValueFromProperty("error") + cnfe);
		} catch (SQLException sqle) {
			System.out.println(getValueFromProperty("error") + sqle);
		} catch (ArithmeticException ae) {
			System.out.println(getValueFromProperty("error") + ae);
		} catch (InputMismatchException ime) {
			System.out.println(getValueFromProperty("error") + ime);
		} catch (Exception e) {
			System.out.println(getValueFromProperty("error") + e);
		}
		return rowCount + " records added.";
	}

	public String deleteEmployee() {

		System.out.print("Enter employee id: ");
		int employeeId = input.nextInt();

		String query = "DELETE from employee WHERE id=?";
		int rowCount = 0;

		try {
			Connection connection = this.getConnection();

			PreparedStatement prepareStatement = connection.prepareStatement(query);
			System.out.println("Statement object created");

			prepareStatement.setInt(1, employeeId);

			rowCount = prepareStatement.executeUpdate();
			System.out.println("Employee Deleted");
			connection.close();
			System.out.println("Connection closed.");

		} catch (ClassNotFoundException cnfe) {
			System.out.println(getValueFromProperty("error") + cnfe);
		} catch (SQLException sqle) {
			System.out.println(getValueFromProperty("error") + sqle);
		} catch (ArithmeticException ae) {
			System.out.println(getValueFromProperty("error") + ae);
		} catch (InputMismatchException ime) {
			System.out.println(getValueFromProperty("error") + ime);
		} catch (Exception e) {
			System.out.println(getValueFromProperty("error") + e);
		}
		return rowCount + "record deleted.";
	}

	public String updateEmployee() {

		System.out.print("Enter employee id: ");
		int employeeId = input.nextInt();

		System.out.println("Which thing do you want to update: 'name' or 'salary' ");
		String field = input.next();
		String query = "UPDATE employee SET " + field + "= ? WHERE id=?";
		int rowCount = 0;

		try {
			Connection connection = this.getConnection();

			PreparedStatement prepareStatement = connection.prepareStatement(query);
			System.out.println("Statement object created");

			if (field.equals("salary")) {
				System.out.println("Enter salary: ");
				int employeeSalary = input.nextInt();
				prepareStatement.setInt(1, employeeSalary);
			} else {
				System.out.println("Enter name: ");
				String employeeName = input.next();
				prepareStatement.setString(1, employeeName);
			}

			prepareStatement.setInt(2, employeeId);
			rowCount = prepareStatement.executeUpdate();
			System.out.println("Employee updated");
			connection.close();

		} catch (ClassNotFoundException cnfe) {
			System.out.println(getValueFromProperty("error") + cnfe);
		} catch (SQLException sqle) {
			System.out.println(getValueFromProperty("error") + sqle);
		} catch (ArithmeticException ae) {
			System.out.println(getValueFromProperty("error") + ae);
		} catch (InputMismatchException ime) {
			System.out.println(getValueFromProperty("error") + ime);
		} catch (Exception e) {
			System.out.println(getValueFromProperty("error") + e);
		}
		return rowCount + "record updated.";
	}

	public void printEmployee() {

		String query = "SELECT * FROM employee";
		try {
			Connection connection = this.getConnection();

			Statement createStatement = connection.createStatement();
			ResultSet resultSet = createStatement.executeQuery(query);

			while (resultSet.next()) {
				Integer empId = resultSet.getInt("id");
				String empName = resultSet.getString("name");
				Integer empSalary = resultSet.getInt("salary");
				this.employeeMap.put(empId, new Employee(empId, empName, empSalary));
			}

			System.out.println("Employee Data: " + employeeMap);
			connection.close();

		} catch (ClassNotFoundException cnfe) {
			System.out.println(getValueFromProperty("error") + cnfe);
		} catch (SQLException sqle) {
			System.out.println(getValueFromProperty("error") + sqle);
		} catch (ArithmeticException ae) {
			System.out.println(getValueFromProperty("error") + ae);
		} catch (InputMismatchException ime) {
			System.out.println(getValueFromProperty("error") + ime);
		} catch (Exception e) {
			System.out.println(getValueFromProperty("error") + e);
		}
	}

	public void createProperty(String key, String value) {
		try {

			OutputStream outputStream = new FileOutputStream("application.properties", true);

			properties.setProperty(key, value);
			properties.store(outputStream, null);
			System.out.println("File updated");

		} catch (FileNotFoundException fnfe) {
			System.out.println(getValueFromProperty("error") + fnfe);
		} catch (Exception e) {
			System.out.println(getValueFromProperty("error") + e);
		}
	}

	public String getValueFromProperty(String key) {
		
		return properties.getProperty(key);
	}
	public void deleteValueFromProperty(String key) {
		try {

			OutputStream outputStream = new FileOutputStream("application.properties", true);

			properties.remove(key);
			properties.store(outputStream, null);
		
		} catch (FileNotFoundException fnfe) {
			System.out.println(getValueFromProperty("error") + fnfe);
		} catch (Exception e) {
			System.out.println(getValueFromProperty("error") + e);
		}
		
	}
	
	public void sortEmployeeByIdUsingStream() {
		
	}

	public static void main(String[] args) {

		CollectionsCrud collectionsCrud = new CollectionsCrud();
		collectionsCrud.createProperty("error", "Error :");
		//collectionsCrud.sortEmployeeByIdUsingStream();
		//collectionsCrud.createProperty("success", "Success");
		//collectionsCrud.deleteValueFromProperty("error");
		collectionsCrud.printEmployee();
		// collectionsCrud.updateEmployee();
		// collectionsCrud.deleteEmployee();
		// collectionsCrud.insertEmployee();

	}

}
