package com.epam.venkat.v04.functioncomposition;

import java.util.Arrays;
import java.util.List;

public class FunctionComposition {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		printSumOfTheDoublesOfEvens(numbers);
		printSumOfTheDoublesOfEvensWithStream(numbers);
		printSumOfTheDoublesOfEvensWithStreamVersion2(numbers);
	}

	private static void printSumOfTheDoublesOfEvens(List<Integer> numbers) {
		int result = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				result += 2 * number;
			}
		}

		System.out.println("Result: " + result);
	}

	private static void printSumOfTheDoublesOfEvensWithStream(List<Integer> numbers) {
		System.out.println("Result: " + numbers.stream()
				.filter(number -> 0 == number % 2)
				.map(number -> 2 * number)
				.reduce(0, Integer::sum));
	}

	private static void printSumOfTheDoublesOfEvensWithStreamVersion2(List<Integer> numbers) {
		System.out.println("Result: " + numbers.stream()
				.filter(number -> 0 == number % 2)
				.mapToInt(number -> 2 * number)
				.sum());
	}
}
