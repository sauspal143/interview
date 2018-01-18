package com.saurabh.algorithms;

/**
 * The purpose of Kadane's algorithm is to formulate a single pass algorithm to
 * find the maximum sum of sub array for a given set of elements in an array.
 * 
 * @author Saurabh Thakur
 * @date 05/27/2017
 * @version 1.0
 *
 */
public class KadanesAlgorithm {
	
	public static int maximumSubArrayValue(int givenArray[]) {
		int max_so_far = 0;
		int max_ending_here = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		for (int i = 0; i < (givenArray != null ? givenArray.length : 0); i++) {
			System.out.println("Max ending here: " + max_ending_here 
					+ " Max so far: " + max_so_far
					+ " Current array element: " + givenArray[i]
					+ " Start Index: " + startIndex
					+ " End Index: " + endIndex);
			
			max_ending_here += givenArray[i];

			if (max_ending_here < 0) {
				max_ending_here = 0;
				startIndex = i + 1;
			}

			if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
				endIndex = i;
			}
		}
		
		System.out.println("Start Index: " + startIndex + " End Index: " + endIndex);
		return max_so_far;
	}

	public static void main(String[] args) {
		/*int givenArray[] = {-1,-2,3,4,-5,6,-7,-8,16};
		maximumSubArrayValue(givenArray);*/
		
		System.out.println("Result -> " + maximumSubArrayValue(new int[] {-1,-2,3,4,-5,6,-5,-6,8}));
	}

}
