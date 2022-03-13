package java8features.collectionExamples;

import java.util.*;

public class MyCollection {
	public void listDemo() {
		List cars = new ArrayList();
		cars.add("Suzuki");
		cars.add("Honda");
		cars.add("BMW");
		cars.add("Volkswagon");
		//System.out.println("Initial list " + cars);
		//sortUsingComprator(cars);
		//System.out.println("Final List after sorting: " + cars);
		printCarsUsingForEach(cars);
	}
	
	public void sortUsingComprator(List cars) {
		Collections.sort(cars, (c1, c2) ->  ((String) c1).compareTo((String) c2));
	}

	public void printCarsUsingForEach(List cars) {
		cars.forEach( car -> System.out.print(car + " "));
	}

	public static void main(String[] args) {
		MyCollection cars = new MyCollection();
		cars.listDemo();

		
	}

}
