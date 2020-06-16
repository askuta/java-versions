package com.epam.venkat.v05.parallelizing;

import java.util.Arrays;
import java.util.List;

public class Parallelizing {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		runSequentially(numbers);
		runParallelly(numbers);
	}

	private static void runSequentially(List<Integer> numbers) {
		System.out.println("\nRun sequentially...");
		Timeit.code(() -> numbers.stream()
				.filter(number -> 0 == number % 2)
				.mapToInt(Parallelizing::compute)
				.sum());
	}

	private static void runParallelly(List<Integer> numbers) {
		System.out.println("\nRun parallelly...");
		Timeit.code(() -> numbers.parallelStream()
				.filter(number -> 0 == number % 2)
				.mapToInt(Parallelizing::compute)
				.sum());		
	}

	private static int compute(int number) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return 2 * number;
	}
}
