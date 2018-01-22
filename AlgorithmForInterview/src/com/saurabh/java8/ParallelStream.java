package com.saurabh.java8;

import java.util.Arrays;
import java.util.List;

// Use parallel stream if you are willing to spend resources for faster computation
// Data size is as such that you will benefit in performance
public class ParallelStream {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		TimeIt.code(() -> System.out.println(numbers.stream()
			.filter(e -> e % 2 == 0)
			.mapToInt(e -> compute(e))
			.sum()));
		
		TimeIt.code(() -> System.out.println(numbers.parallelStream()
				.filter(e -> e % 2 == 0)
				.mapToInt(ParallelStream::compute)
				.sum()));
	}

	private static Integer compute(Integer e) {
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
		}
		return e * 2;
	}
}
