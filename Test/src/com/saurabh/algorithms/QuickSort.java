package com.saurabh.algorithms;

import java.util.Arrays;

// Given an array we need to first find a pivot to start the partitioning process.
// QuickSort has a Time complexity of O(n log n) for average case and worst case it is O(n2). 
// The worst case can be avoided by using Randomized Quick Sort implementation
// For practical purposes even tough worst case time complexity is O(n2) 
// quick sort gives better performance as that scenario occurs rarely
// Our quickSort method will have parameters as array, lowIndex, highIndex
// quickSort(array, 0, array.length - 1)
// Recursive calls need to be made to quickSort method and breaking mechanism need to be in place 
// else the whole code will go in an infinite loop
public class QuickSort {

	private static void quickSortOld(int array[], int left, int right) {
		printArray(array);
		System.out.println("LowIndex -> " + left + " | HighIndex -> " + right);
		// if (left > right) {
		if (left < right) {
			//System.out.println("ALL DONE ...");
			//return;
		//}
		
		// int pIndex = Math.abs((left + right)/2);
		// int pivot = array[pIndex];
		// System.out.println("Selected pivot -> " + pivot);
		
		// int partitionedIndex = partition(array, left, right, pivot, pIndex);
		int partitionedIndex = partition(array, left, right);
		quickSort(array, left, partitionedIndex - 1);
		quickSort(array, partitionedIndex, right);
		}
	}
	
	private static void quickSort(int A[], int start, int end) {
		printArray(A);
		System.out.println("StartIndex -> " + start + " | EndIndex -> " + end);
		if (start < end) {
			int partitionedIndex = partition(A, start, end);
			quickSort(A, start, partitionedIndex - 1);
			quickSort(A, partitionedIndex + 1, end);
		}
	}
	
	private static int partition(int[] A, int start, int end) {
		int pivot = A[end];
		int partitionIndex = start;
		for (int i = start; i < end; i++) {
			if (A[i] <= pivot) {
				System.out.println("i -> " + i + " | partitionIndex -> " + partitionIndex);
				swapBasic(A, i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(A, partitionIndex, end);
		return partitionIndex;
	}

	private static void swap(int[] array, int lowIndex, int highIndex) {
		System.out.println("BEFORE SWAPPING ...");
		printArray(array);
		// a = 5, b = 3;
		// a = a + b;
		// b = a - b;
		// a = a - b;
		array[highIndex] = array[highIndex] + array[lowIndex];
		array[lowIndex] = array[highIndex] - array[lowIndex];
		array[highIndex] = array[highIndex] - array[lowIndex];
		System.out.println("AFTER SWAPPING ...");
		printArray(array);
	}
	
	private static void swapBasic(int[] array, int lowIndex, int highIndex) {
		System.out.println("BEFORE SWAPPING ...");
		printArray(array);
		int temp = array[highIndex];
		array[highIndex] = array[lowIndex];
		array[lowIndex] = temp;
		System.out.println("AFTER SWAPPING ...");
		printArray(array);
	}
	

	
	private static int partitionOld(int[] array, int left, int right, int pivot, int pIndex) {
		while (left < right) {
			while (array[left] < pivot) {
				left++;
			}
				
			while (array[right] > pivot) {
				right--;
			}
			
			if (left == pIndex && array[right] < pivot) {
				swap(array, left, right);
				pivot = array[left];
			} else {
				swap(array, left, right);
				left++;
				right--;
			}
			
			System.out.println("END OF LOOP | LowIndex -> " + left + " HighIndex -> " + right);
		}
		
		return left;
	}

	private static void printArray(int array[]) {
		System.out.println("Array => " + Arrays.toString(array) + "\n");
	}
	
	public static void main(String[] args) {
		// int array[] = new int[] {33,7,20,13,40,31,9,39,30,25,27};
		int array[] = new int[] {33,7,20,13,40,31,9,39,30,25,27};
		quickSort(array, 0, array.length - 1);
		System.out.println("HURRAY !!! SORTING COMPLETE \n");
		printArray(array);
	}
}
