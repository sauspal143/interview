package com.saurabh.algorithms;
// Given an array we need to find if a element exist or not
// For the same we will create a methos which will accept 3 parameters
// Array, length of array and number to find
// binarySearch(array, length, x)
// initialize low and high index point
// low <- 0
// high <- n-1

// **** important condition while (low <= high) perform below task
// mid <- (low + high)/2
// if (x == array[mid]) 
//    return mid
// if (x < array[mid])
//    high <- mid - 1
// else if ( x > array[mid])
//    low -> mid + 1
// if not able to find anything return -1

public class BinarySearch {
	
	// The below method finds the FIRST index of occurrence 
	private static int binarySearchDuplicates(int[] array, int size, int x) {
		int lowIndexPointer = 0;
		int highIndexPointer = size - 1;
		int result = -1; // In case multiple elements in the array have same x value and you have to find the first occurrence
		
		while (lowIndexPointer <= highIndexPointer) {
			int midIndexPointer = Math.abs((lowIndexPointer + highIndexPointer)/2);
			System.out.println("INDEX: High -> " + highIndexPointer + " | Middle -> " + midIndexPointer + " | Low -> " + lowIndexPointer);
			System.out.println("ELEMENT: High -> " + array[highIndexPointer] + " | Middle -> " + array[midIndexPointer] + " | Low -> " + array[lowIndexPointer] + "\n");
			if (x == array[midIndexPointer]) {
				result = midIndexPointer;
				// highIndexPointer = midIndexPointer - 1; // FIRST Index of occurrence of x
				lowIndexPointer = midIndexPointer + 1; // LAST Index of occurrence of x
			} else if (x < array[midIndexPointer]) { // If my value is less then mid value then my highIndex need to be adjusted
				System.out.println(" x is less case executed ... x => " + x + " array[midIndexPointer] => " + array[midIndexPointer]);
				highIndexPointer = midIndexPointer - 1;
			} else {
				System.out.println(" x is more case executed ... x => " + x + " array[midIndexPointer] => " + array[midIndexPointer]);
				lowIndexPointer = midIndexPointer + 1;
			}
		}
		
		return result;
	}
	
	private static int binarySearch(int[] array, int size, int x) {
		int lowIndexPointer = 0;
		int highIndexPointer = size - 1;
		
		while (lowIndexPointer <= highIndexPointer) {
			int midIndexPointer = Math.abs((lowIndexPointer + highIndexPointer)/2);
			System.out.println("INDEX: High -> " + highIndexPointer + " Middle -> " + midIndexPointer + " Low -> " + lowIndexPointer);
			System.out.println("ELEMENT: High -> " + array[highIndexPointer] + " Middle -> " + array[midIndexPointer] + " Low -> " + array[lowIndexPointer] + "\n");
			if (x == array[midIndexPointer]) {
				return midIndexPointer;
			} else if (x < array[midIndexPointer]) { // If my value is less then mid value then my highIndex need to be adjusted
				System.out.println(" x is less case executed ... x => " + x + " array[midIndexPointer] => " + array[midIndexPointer]);
				highIndexPointer = midIndexPointer - 1;
			} else {
				System.out.println(" x is more case executed ... x => " + x + " array[midIndexPointer] => " + array[midIndexPointer]);
				lowIndexPointer = midIndexPointer + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		int array[] = new int[] {1, 5, 10, 13, 17, 20, 30, 40, 50}; // Sorted list
		int arrayDuplicates[] = new int[] {1, 5, 10, 10, 10, 20, 30, 40, 50}; // Containing duplicate elements list
		int size = 9;
		int x = 10;
		int result;
		boolean duplicateFlag = true;
		
		if (duplicateFlag) {
			result = binarySearchDuplicates(arrayDuplicates, size, x);
		} else {
			result = binarySearch(array, size, x);
		}
		
		
		if (result == -1) {
			System.out.println("The number x => " + x + " was NOT found in array => " + array);
		} else {
			System.out.println("The number x => " + x + " was found at index => " + result);
		}
	}
}
