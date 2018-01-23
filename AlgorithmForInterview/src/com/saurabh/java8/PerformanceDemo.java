package com.saurabh.java8;

import java.util.Arrays;
import java.util.List;

public class PerformanceDemo {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,20);
		
		// Given an ordered list find the double of the first even number greater than 3
		
		int result = 0;
		// Traditional way
		for (int e : numbers) {
			if (e > 3 && e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		System.out.println(result);
		// Above code took 7 unit of work;
		
		// For below code
		// 20 + 17 + 9 = 46 unit of work That what is the understanding but not true
		// Stream is absolutely lazy, it attaches functions till computation is triggered 
		// filter -> filter -> map once findFirst is called computation triggers
		// Java 8 stream takes first element and try to apply all functions on it 
		// if condition one satisfies proceed to condition two so on and so forth till exact match found
		// NOTE: Evalutions are only performed when triggering the terminal operation
		System.out.println(numbers.stream()
			.filter(e -> e > 3)
			.filter(e -> (e % 2 == 0))
			.map(e -> e * 2)
			.findFirst() // Comment this if you don't want to trigger evaluation
			);
		
		// Lazy evaluation is possible only if the functions don't have side effect (Don't print stuff like in below example)
		System.out.println(numbers.stream()
				.filter(PerformanceDemo::isGT3)
				.filter(PerformanceDemo::isEven)
				.map(PerformanceDemo::doubleIt)
				.findFirst()
				);
	}
	
	public static boolean isGT3(int number) {
		System.out.println("isGT3 " + number);
		return number > 3;
	}
	
	public static boolean isEven(int number) {
		System.out.println("isEven " + number);
		return number % 2 == 0;
	}
	
	public static int doubleIt(int number) {
		System.out.println("doubleIt " + number);
		return number * 2;
	}
}
