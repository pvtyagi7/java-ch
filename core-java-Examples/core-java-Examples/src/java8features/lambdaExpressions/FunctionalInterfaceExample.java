package java8features.lambdaExpressions;

public class FunctionalInterfaceExample implements Drawable{
	@Override
	public void draw() { 
		System.out.println("Drawing Circle using with normal method");
	}
	
	public void drawUsingAnonymousMethod() {
		Drawable d1 = () -> {
			System.out.println("Drawing circle using anonymous method");
		};
		d1.draw();
	}
	
	public void calculateUsingAnonymousMethod(double number1, double number2) {
		Calculate d1 = (num1, num2) -> num1+ num2;
		
		Double addition = d1.add(number1, number2);
		System.out.println("Addition is: " + addition);
	}
	
	public static void main(String[] args) {
		FunctionalInterfaceExample functionalInterfaceExample1 = new FunctionalInterfaceExample();
		
		// calling a normal method to draw a shape
		functionalInterfaceExample1.draw();
		
		// using anonymous method to draw a shape
		functionalInterfaceExample1.drawUsingAnonymousMethod();
		
		// using anonumous method to draw a shape with parameters
		functionalInterfaceExample1.calculateUsingAnonymousMethod(5,15.2);
	}

}
