package java8features.collectionExamples;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapExamples {
	static Scanner input = new Scanner(System.in);

	static Map<Integer, Employee> employee = new HashMap<>();
	static LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
	
	public static void addLinkedHashMap() {
		linkedHashMap.put(101, "Rahul");
		linkedHashMap.put(102, "Raju");
		linkedHashMap.put(104, "Sonu");
		linkedHashMap.put(103, "Manav");
		System.out.println(linkedHashMap);
		
	}
	
	public static void removeLinkedHashMap(int key) {
		String response = linkedHashMap.remove(key) != null ? "deleted" : "not deleted";
		System.out.println(key + " removed");
		System.out.println(linkedHashMap);
	}
	
	public static void updateLinkedHashMap(int key, String value) {
		String response = linkedHashMap.replace(key, value) != null ? "updated" : "not udpated";
		System.out.println(key + " " + response);
		System.out.println(linkedHashMap);
	}
	
	public static void printLinkedHashMap() {
	
	}
	
	public static void copyMap() {
		HashMap<Integer, String> linkedHashMap2 = new LinkedHashMap<>();
		
		System.out.println("Map1: " + linkedHashMap);
		System.out.println("Map2: " + linkedHashMap2);
		
		linkedHashMap2.putAll(linkedHashMap);
		System.out.println("Copied.");
		System.out.println("Map1: " + linkedHashMap);
		System.out.println("Map2: " + linkedHashMap2);
	
	}
		
	
	public static String addEmployee() {

		employee.put(101, new Employee(101, "Rohit", 5000.0f));
		employee.put(102, new Employee(102, "Mohit", 55000.0f));
		employee.put(103, new Employee(103, "Sumit", 65000.0f));
		employee.put(104, new Employee(104, "Amit", 25000.0f));
		employee.put(105, new Employee(105, "Rohan", 15000.0f));

		/*
		 * System.out.print("Enter employee id: "); int employeeId = input.nextInt();
		 * System.out.print("Enter employee name: "); String employeeName =
		 * input.next(); System.out.print("Enter employee salary: "); float
		 * employeeSalary = input.nextFloat(); employee.put(101, new
		 * Employee(employeeId, employeeName, employeeSalary));
		 */
		return "Employees added.";
	}

	public static void printEmployeeUsingIterator() {
		Set employeeSet = employee.entrySet();

		Iterator<Employee> iterator = employeeSet.iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Employee> mapEntry = (Entry<Integer, Employee>) iterator.next();
			System.out.println("id: " + mapEntry.getKey() + " Value: " + mapEntry.getValue());
		}
	}

	public static void printEmployeeUsingForEachLoop() {
		for (Map.Entry<Integer, Employee> mapEntry : employee.entrySet()) {
			System.out.println("id: " + mapEntry.getKey() + " Value: " + mapEntry.getValue());
		}
	}

	public static void printEmployeeUsingForEachMethod() {
		employee.forEach((employeeId, employee) -> System.out.println("id: " + employeeId + " Value: " + employee));
	}

	public static void deleteEmployee(int employeeId) {
		String response = employee.remove(employeeId) != null ? "deleted" : "not deleted";

		System.out.println(employeeId + " " + response);
	}

	public static void updateEmployee(int employeeId, Employee newEmployeeData) {
		String response = employee.replace(employeeId, newEmployeeData) != null ? "updated" : "not udpated";

		System.out.println(employeeId + " " + response);
	}

	public static void main(String[] args) {
		addLinkedHashMap();
		updateLinkedHashMap(104, "Deepak");
		removeLinkedHashMap(101);
		copyMap();

	/*	System.out.println(addEmployee());
		printEmployeeUsingIterator();

		deleteEmployee(101);

		printEmployeeUsingForEachLoop();
		updateEmployee(102, new Employee(102, "Sona", 8000));
		printEmployeeUsingForEachMethod();
		*/
		//
//		PropertyValues properties = new PropertyValues();
//		try {
//			System.out.println(properties.getPropValues());
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
