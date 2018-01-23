package com.saurabh.java8;

import java.util.Arrays;
import java.util.List;

public class StreamCharacteristics {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		
		numbers.stream()
			.filter(e -> e % 2 == 0)
			.forEach(System.out::println);
		// sized, ordered, non-distinct, non-sorted
		System.out.println();
		numbers.stream()
			.filter(e -> e % 2 == 0)
			.sorted() // Sort elements in stream
			.forEach(System.out::println);
		// sized, ordered, non-distinct, sorted
		System.out.println();
		numbers.stream()
			.filter(e -> e % 2 == 0)
			.sorted()
			.distinct() // Distinct elements in stream
			.forEach(System.out::println);
		// sized, ordered, distinct, sorted
	}
}
