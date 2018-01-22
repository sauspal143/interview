package com.saurabh.java8;

// Lambda expressions are means to create anonymous classes of functional interfaces easily.
// An interface with exactly one abstract method becomes Functional Interface. 
/*@FunctionalInterface
public interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}*/
public class LamdaExpression { // Based on invokedynamic - functions can attach and detach dynamically
	
	// Normal function is made up of 4 parts
	// 1. name - This becomes anonymous in Java 8
		// 2. paramters
		// 3. body
	// return type - This gets inferred in Java 8
	
	public static void main(String args[]) {
		System.out.println("In main");
		
		// Here new Runnable is Anonymous Inner class which is kind of basis of lamda expression
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("In subthread ... ");
				
			}
		});
		th.start();
		
		// Above code in Java8 would be 
		Thread th2 = new Thread(() -> System.out.println("Inside Java 8 thread"));
		th2.start();
	}

}
