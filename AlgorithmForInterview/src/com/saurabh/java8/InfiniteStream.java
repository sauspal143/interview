package com.saurabh.java8;

import java.util.stream.Stream;

public class InfiniteStream {

	public static void main(String[] args) {
		System.out.println(Stream.iterate(100, e -> e + 1));
		// O/p -> java.util.stream.ReferencePipeline$Head@1218025c - Point to the head of stream
		
		// Start with 100, create a series
		// 100, 101, 102, 103, ...
		
		System.out.println(Stream.iterate(100, e -> e + 1)
									.filter(e -> e % 2 == 0));
		// O/p -> java.util.stream.ReferencePipeline$2@53d8d10a
		
		// Given a number k and count n, find the total of double of n even numbers
		// starting with k, where sqrt of each number is > 20
		
		int k = 121;
		int n = 51;
		System.out.println(compute(k, n));
	}

	private static int compute(int k, int n) {
		int result = 0;
		
		/* int index = k;
		int count = 0;
		
		while (count < n) {
			if (index % 2 == 0 && Math.sqrt(index) > 20) {
				result += index * 2;
				count++;
			}
			index++;
		} */
		
		result = Stream.iterate(k, e -> e + 1) // unbounded, lazy
				.filter(e -> e % 2 == 0) // unbounded, lazy
				.filter(e -> Math.sqrt(e) > 20) // unbounded, lazy
				.mapToInt(e -> e * 2) // unbounded, lazy
				.limit(n) // sized, lazy
				.sum();
		
		// Look for the return type of function to understand if it is Lazy or Eager
		
		return result;
	}

}
