package com.epam.venkat.v08.performance;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Performance {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

		execute(numbers);
		executeWithStream(numbers);
	}

	private static void execute(List<Integer> numbers) {
		int result = 0;
		for (int number : numbers) {
			if (number > 3 && 0 == number % 2) {
				result = 2 * number;
				break;
			}
		}

		System.out.println("Result: " + result);
	}

	private static void executeWithStream(List<Integer> numbers) {
		Optional<Integer> result = numbers.stream()
				.filter(Performance::isGT3)
				.filter(Performance::isEven)
				.map(Performance::doubleIt)
				.findFirst();

		System.out.println("Result: " + result);
	}

	private static boolean isGT3(int number) {
		System.out.println("\texecutes isGT3(" + number + ")");
		return number > 3;
	}

	private static boolean isEven(int number) {
		System.out.println("\texecutes isEven(" + number + ")");
		return 0 == number % 2;
	}

	private static int doubleIt(int number) {
		System.out.println("\texecutes doubleIt(" + number + ")");
		return 2 * number;
	}
}
