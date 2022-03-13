package java8features.interfaces;

interface Sayable {
		
	void sayMore(String mag);
	default void sayDefault (){
		System.out.println("Inside default method");
	}
	static void sayLouder(String msg) {
		System.out.println("In static method of interface: " + msg);
	}
	
}
