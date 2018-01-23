package com.saurabh.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

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
		
		// Wrong way to do
		List<Integer> doubleOfEven = new ArrayList<Integer>();
		numbers.stream()
				.filter(e -> (e % 2 == 0))
				.map(e -> e * 2)
				.forEach(e -> doubleOfEven.add(e));
		System.out.println(doubleOfEven); // Violating stream shared mutability
		// mutability is OK, sharing is nice, shared mutability is devils work
		// friends don't let friends do shared mutation.
		
		// Better way
		numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		List<Integer> doubleOfEven2 = numbers.stream()
				.filter(e -> (e % 2 == 0))
				.map(e -> e * 2)
				.collect(toList());
		System.out.println(doubleOfEven2);
		
		// To eliminate duplicate values if present in original array
		Set<Integer> doubleOfEven3 = numbers.stream()
				.filter(e -> (e % 2 == 0))
				.map(e -> e * 2)
				.collect(toSet());
		System.out.println(doubleOfEven3);
		
		// Java 8 way
		numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
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
