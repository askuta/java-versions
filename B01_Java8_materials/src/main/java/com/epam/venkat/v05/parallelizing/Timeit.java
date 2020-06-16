package com.epam.venkat.v05.parallelizing;

public class Timeit {

	public static void code(Runnable block) {
		long start = System.nanoTime();

		try {
			block.run();
		} finally {
			long end = System.nanoTime();
			System.out.println("\tTime taken: " + (end - start) / 1.0E9);
		}
	}
}
