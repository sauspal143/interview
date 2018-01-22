package com.saurabh.java8;

public class TimeIt {
	
	public static void code(Runnable block) {
		long start = System.nanoTime();
		
		try {
			block.run();
		} finally {
			long end = System.nanoTime();
			System.out.println("Time taken: " + (end - start)/1.0e9);
		}
	}

}
