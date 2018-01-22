package com.saurabh.algorithms;

import java.util.Arrays;

public class EliminateDuplicate {

	public static int[] fetchUniqueElementArrayBruteForce(int numbers[]) {
		int tempArray[];
		int count = 0;
		int tempArraySize = 0;

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					if (numbers[i] != -1) {
						System.out.println(
								"Number -> " + numbers[i] + " at index " + i + " has duplicate value at index -> " + j);
						numbers[j] = -1;
						tempArraySize++;
					}
				}
			}
		}

		tempArraySize = numbers.length - tempArraySize;
		tempArray = new int[tempArraySize];

		for (int k = 0; k < numbers.length; k++) {
			if (numbers[k] != -1) {
				tempArray[count++] = numbers[k];
			}
		}
		return tempArray;
	}
	
	public static int[] fetchUniqueElementArraySinglePassOrderNotMaintained(int numbers[]) {
		int tempArray[] = new int[numbers.length];
		int count = 0;

		for (int i = 0; i < numbers.length; i++) {
			boolean duplicateFound = false;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					System.out.println(
							"Number -> " + numbers[i] + " at index " + i + " has duplicate value at index -> " + j);
					numbers[i] = -1;
					duplicateFound = true;
					break;
				}
			}
			
			if (!duplicateFound) {
				tempArray[count++] = numbers[i];
			}
		}

		/*for (int k = 0; k < numbers.length; k++) {
			if (numbers[k] != -1) {
				tempArray[count++] = numbers[k];
			}
		}*/
		return tempArray;
	}

	public static void main(String[] args) {

		int numbers[] = { 9, 10, 2, 1, 2, 4, 5, 2, 1, 2, 4, 6, 7};

		/*System.out.println("Final array after eliminating duplicates is -> "
				+ Arrays.toString(fetchUniqueElementArrayBruteForce(numbers)));*/
		
		System.out.println("Final array after eliminating duplicates is -> "
				+ Arrays.toString(fetchUniqueElementArraySinglePassOrderNotMaintained(numbers)));
	}
	

}
