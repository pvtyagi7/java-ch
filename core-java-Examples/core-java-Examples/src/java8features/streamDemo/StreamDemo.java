package java8features.streamDemo;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class StreamDemo {

	List<Product> productsList = new ArrayList<Product>();
	public void addProducts() {
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
	}
	public List<Float> getFilteredPriceList() {
		
		return productsList.stream().filter(product -> product.price > 30000).map(product -> product.price)
				.collect(Collectors.toList());
	}

	public void printFilteredPriceUsingForEach() {
		
		productsList.stream().filter(product -> product.price > 30000).map(product -> product.price)
				.forEach(System.out::println);

	}
	public void streamIterator() {
		Stream.iterate(0, element -> element +1).forEach(System.out::print);
	}
	public void forEachStream() {
		productsList.forEach(product -> {
			System.out.println(product.name);
			
		});
	}
	public void countingStream() {
		long totalItems = productsList.stream().map(item -> item.id)
		.collect(Collectors.counting());
		System.out.println("Total no. of Items: " + totalItems);
	}
	public void averagingStream() {
		double averagePrice = productsList.stream().map(item -> item.price)
		.collect(Collectors.averagingDouble(item -> item));
		System.out.println("average price: " + averagePrice);
	}
	
	public void summingStream() {
		double totalPrice = productsList.stream().map(item -> item.price)
		.collect(Collectors.summingDouble(item -> item));
		System.out.println("Total price: " + totalPrice);
	}
	
	public static void main(String[] args) {
		
		StreamDemo streamDemo = new StreamDemo();
		streamDemo.addProducts();
		
		streamDemo.countingStream();
		streamDemo.averagingStream();
		streamDemo.summingStream();
		//streamDemo.streamIterator();
		//streamDemo.forEachStream();
		//streamDemo.printFilteredPriceUsingForEach();
		//System.out.print(streamDemo.getFilteredPriceList());
/*
		List<Product> productsList = new ArrayList<Product>();

		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

//	        List prices = productsList.stream().filter(product -> product.price > 3000)
//	        .map(product -> product.price).collect(Collectors.toList());
//	        System.out.println(prices);
		productsList.stream().filter(product -> product.price > 3000).map(product -> product.price)
				.forEach(System.out::println);*/

	}
}