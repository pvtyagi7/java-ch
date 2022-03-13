package java8features.collectionExamples;

public class Employee {
	private int empId;
	private String name;
	private float salary;
	
	Employee() {}
	
	Employee(int empId, String name, float salary) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public String getName() {
		return name;
	}
	
	public float getSalary() {
		return salary;
	}
	
	public String toString() {
		return empId + " " + name + " " + salary;
	}

}
