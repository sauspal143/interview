package com.saurabh.java8;

import java.util.Arrays;
import java.util.List;

public class DoubleEvenNumbers {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		int result = 0;
		// Traditional way
		for (int i=0;i<=numbers.size();i++) {
			if (i % 2 == 0) {
				result += (i * 2);
			}
		}
		System.out.println(result);
		
		// Java 8 way
		System.out.println(numbers.stream()
			.filter(e -> (e % 2 == 0))
			.map(e -> e * 2)
			.reduce(0, Integer::sum)
			);
		
		// Even better
		System.out.println(numbers.stream()
				.filter(e -> (e % 2 == 0))
				.mapToInt(e -> e * 2)
				.sum()
				);
			
	}
}
