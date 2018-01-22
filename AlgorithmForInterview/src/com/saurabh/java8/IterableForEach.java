package com.saurabh.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// forEach mechanism hides the implementation of iteration from the users like polymorphism
public class IterableForEach {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		// external iterators
		// first way
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		// second way
		for (int e : numbers) {
			System.out.println(e);
		}
		
		// internal iterator
		numbers.forEach(e -> System.out.println(e));
		
		numbers.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer value) {
				System.out.println(value);
			}
		});
		
		// Deduced from above code in one line
		numbers.forEach((Integer value) ->  System.out.println(value));
		
		numbers.forEach(value ->  System.out.println(value));
		
		numbers.forEach(System.out::println); // Method reference
		
		// Few more examples:
		numbers.stream()
			.map(e -> String.valueOf(e))
			.forEach(System.out::println);
		
		// Can also be written as 
		numbers.stream()
			.map(String::valueOf) // Static method, here paramater becomes argument
			.forEach(System.out::println); // Instance method, here paramater becomes argument
		
		numbers.stream()
			.map(e -> e.toString()) // Here paramater becomes target
			.forEach(System.out::println);
		
		// Can also be written as
		numbers.stream()
			.map(e -> String.valueOf(e))
			.map(String::toString)
			.forEach(System.out::println);
		
		// To deal with two parameters
		// Both parameters as argument
		System.out.println(numbers.stream().reduce(0,(total,e) -> Integer.sum(total, e))); 
		
		System.out.println(numbers.stream().reduce(0, Integer::sum));
		
		// One parameters as target and the other as argument
		System.out.println(numbers.stream()
				.map(String::valueOf)
				.reduce("",(carry,str) -> carry.concat(str))); 
		
		System.out.println(numbers.stream()
				.map(String::valueOf)
				.reduce("",String::concat)); 
	}

}
