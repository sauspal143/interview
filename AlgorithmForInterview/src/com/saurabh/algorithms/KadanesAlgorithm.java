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
public class KadanesAlgorithm { // Maximum Sub array sum
	
	public static final Integer maxNegativeInteger = new Integer(Integer.MIN_VALUE);
	
	/**
	 * 
	 * This method breaks the main array in smaller sub_arrays and see if the sum of the subarray is greater or less than
	 * the store result of previous computation.
	 * Since we have to compute sum of every subarray combinations we declare inital for loop for sub_array first
	 * than we iterate over individual elements in the subarray from start_index
	 * 
	 * But if we observe carefully because of this approach we are computing always the subarray from start index 
	 * which mean sum for subsequent subarray will be previous sum plus current element
	 * e.g | 3 | -2 | 5 | -1 |
	 *       0    1   3    3
	 *     | 3 |  
	 *     | 3 | -2 | 
	 *     | 3 | -2 | 5 | 
	 * 	   | 3 | -2 | 5 | -1 |
	 * 
	 * as seen every time previous subarray gets repeated
	 */
	public static int bruteforceMethod(int numbers[], int size) { // Time Complexity O (n^3) n cube
		int result = maxNegativeInteger;
		
		for (int sub_array_size = 1; sub_array_size <= size; sub_array_size++) {
			for (int start_index = 0; start_index < size; start_index++) {
				if(start_index + sub_array_size > size) { // To check if subarray exceeds array bounds
					break;
				}
				
				int sum = 0;
				for (int i = start_index; i < (start_index + sub_array_size); i++) {
					sum += numbers[i]; // This will collect sum of all elements in the subarray
				}
				
				result = Integer.max(result, sum);
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * Based on observations from above method instead of letting subarray size drive the algorithm
	 * we will ensure that we compute sum at the particular start index and then check if it is
	 * greater than the previous result stored. 
	 */
	public static int bruteforceMethodTimeReduced(int numbers[], int size) { // Time Complexity O (n^2) n square
		int result = maxNegativeInteger;
		
		for (int start_index = 0; start_index < size; start_index++) {
			int sum = 0;
			for (int sub_array_size = 1; sub_array_size <= size; sub_array_size++) {
				if(start_index + sub_array_size > size) { // To check if subarray exceeds array bounds
					break;
				}
				// If k elements are present we always compute k - 1 elements and store it in sum
				sum += numbers[start_index + sub_array_size - 1]; // This gives Last element of the new Subarray
				result = Integer.max(result, sum);
			}
		}
		
		return result;
	}
	
	public static int divideAndConqure(int numbers[], int size) { // Time Complexity O (n^2) n square
		if(size==1)
		{
			return numbers[0];
		}
		int m = size/2;
		int left_MSS = divideAndConqure(numbers,m);
		//int right_MSS = divideAndConqure(numbers+m,size-m); // I guess we need to pass start index and end index
		int leftsum = maxNegativeInteger, rightsum = maxNegativeInteger, sum=0;
		for(int i=m;i < size; i++)
		{
			sum += numbers[i];
			rightsum = Integer.max(rightsum,sum);
		}
		sum = 0;
		for(int i= (m-1);i >= 0; i--)
		{
			sum += numbers[i];
			leftsum = Integer.max(leftsum,sum);
		}
		//int ans = Integer.max(left_MSS,right_MSS);
		int ans=0;
		return Integer.max(ans,leftsum+rightsum);
	}
	
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
		
		// System.out.println("Result -> " + maximumSubArrayValue(new int[] {-1,-2,3,4,-5,6,-5,-6,8}));
		// System.out.println("Result -> " + bruteforceMethod(new int[] {-1,-2,3,4,-5,6,-5,-6,8}, 9));
		System.out.println("Result -> " + bruteforceMethodTimeReduced(new int[] {-1,-2,3,4,-5,6,-5,-6,8}, 9));
	}

}
