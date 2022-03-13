package crudOperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeOperations {
	static List<Employee> employeeList = new ArrayList<>();

	public static void addEmployeesToList() {
		employeeList.add(new Employee(200, "Sumit", 43332.0f));
		employeeList.add(new Employee(105, "Mohit", 55000.0f));
		employeeList.add(new Employee(602, "Jony", 65000.0f));
		employeeList.add(new Employee(104, "Amit", 25000.0f));
		employeeList.add(new Employee(505, "Rohan", 15000.0f));
	}

	public static void printEmployeeList(List<Employee> empList) {
		empList.stream().collect(Collectors.toList()).forEach(System.out::println);
	}
	
	public static void printEmployeeList() {
		employeeList.stream().collect(Collectors.toList()).forEach(System.out::println);
	}
	public static List<Employee> sortEmployeeByIdUsingStreamInAscending() {
		Comparator<Employee> comparator = (emp1, emp2) -> {

			if (emp1.getEmpId() > emp2.getEmpId())
				return 1;

			else if (emp1.getEmpId() < emp2.getEmpId())
				return -1;

			else
				return 0;
		};

		List<Employee> sortedIdData = employeeList.stream().sorted(comparator).collect(Collectors.toList());
		return sortedIdData;
	}

	public static List<Employee> sortEmployeeByIdUsingStreamInDescending() {
		Comparator<Employee> comparator = (emp1, emp2) -> {

			if (emp1.getEmpId() > emp2.getEmpId())
				return -1;

			else if (emp1.getEmpId() < emp2.getEmpId())
				return 1;

			else
				return 0;
		};

		List<Employee> sortedIdData = employeeList.stream().sorted(comparator).collect(Collectors.toList());
		return sortedIdData;
	}

	public static void sortEmloyeeByIdUsingListInAscending() {

		employeeList.sort((emp1, emp2) -> {
			if (emp1.getEmpId() > emp2.getEmpId())
				return 1;
			else if (emp2.getEmpId() > emp1.getEmpId())
				return -1;
			else
				return 0;
		});

	}
	public static void sortEmloyeeByIdUsingListInDescending() {

		employeeList.sort((emp1, emp2) -> {
			if (emp2.getEmpId() > emp1.getEmpId())
				return 1;
			else if (emp1.getEmpId() > emp2.getEmpId())
				return -1;
			else
				return 0;
		});

	}


	public static List<Employee> sortEmployeeBySalaryUsingStreamInAscending() {
		Comparator<Employee> comparator = (emp1, emp2) -> {

			if (emp1.getSalary() > emp2.getSalary())
				return 1;

			else if (emp1.getSalary() < emp2.getSalary())
				return -1;

			else
				return 0;
		};

		List<Employee> sortedIdData = employeeList.stream().sorted(comparator).collect(Collectors.toList());
		return sortedIdData;
	}

	public static List<Employee> sortEmployeeBySalaryUsingStreamInDescending() {
		Comparator<Employee> comparator = (emp1, emp2) -> {

			if (emp1.getSalary() > emp2.getSalary())
				return -1;

			else if (emp1.getSalary() < emp2.getSalary())
				return 1;

			else
				return 0;
		};

		List<Employee> sortedIdData = employeeList.stream().sorted(comparator).collect(Collectors.toList());
		return sortedIdData;
	}

	public static void sortEmlpoyeeBySalaryUsingListInAscending() {

		employeeList.sort((emp1, emp2) -> {
			if (emp1.getSalary() > emp2.getSalary())
				return 1;
			else if (emp2.getSalary() > emp1.getSalary())
				return -1;
			else
				return 0;
		});

	}
	public static void sortEmployeeBySalaryUsingListInDescending() {

		employeeList.sort((emp1, emp2) -> {
			if (emp2.getSalary() > emp1.getSalary())
				return 1;
			else if (emp1.getSalary() > emp2.getSalary())
				return -1;
			else
				return 0;
		});

	}
	

	public static List<Employee> sortEmployeeByNameUsingStreamInAscending() {
		Comparator<Employee> comparator = (emp1, emp2) -> emp1.getName().compareTo(emp2.getName());

		List<Employee> sortedIdData = employeeList.stream().sorted(comparator).collect(Collectors.toList());
		return sortedIdData;
	}

	public static List<Employee> sortEmployeeByNameUsingStreamInDescending() {
		Comparator<Employee> comparator = (emp1, emp2) -> emp2.getName().compareTo(emp1.getName());

		List<Employee> sortedIdData = employeeList.stream().sorted(comparator).collect(Collectors.toList());
		return sortedIdData;
	}

	public static void sortEmloyeeByNameUsingListInAscending() {

		employeeList.sort((emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));

	}
	public static void sortEmloyeeByNameUsingListInDescending() {

		employeeList.sort((emp1, emp2) -> -emp1.getName().compareTo(emp2.getName()));

	}


	

	
	public static void main(String[] args) {
		addEmployeesToList();
		// List<Employee> sortedById = sortEmployeeByIdUsingStreamInAscending();
		//List <Employee> sortedById = sortEmloyeeByIdUsingListInAscending()
		//List<Employee> sortedById = sortEmployeeByIdUsingStreamInDescending();
		
		//printEmployeeList(sortedById);

//		List<Employee> sortedBySalary = sortEmployeeBySalaryUsingStreamInAscending();
//		List<Employee> sortedBySalary = sortEmployeeBySalaryUsingStreamInDescending();
//		printEmployeeList(sortedBySalary);
//		sortEmlpoyeeBySalaryUsingListInAscending();
//		sortEmployeeBySalaryUsingListInDescending();

//		printEmployeeList();

//		List<Employee> sortedByName = sortEmployeeByNameUsingStreamInAscending();
//		List<Employee> sortedByName = sortEmployeeByNameUsingStreamInDescending();

//		printEmployeeList(sortedByName);

//		sortEmloyeeByNameUsingListInAscending();
		sortEmloyeeByNameUsingListInDescending();
		
		printEmployeeList();

	}

}
