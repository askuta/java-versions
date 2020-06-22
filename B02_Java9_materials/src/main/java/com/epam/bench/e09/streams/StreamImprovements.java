package com.epam.bench.e09.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamImprovements {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1);

		takeWhileExample(numbers);
		dropWhileExample(numbers);
		ofNullableExample(numbers);
		iterateExample();
	}

	private static void takeWhileExample(List<Integer> numbers) {
		List<Integer> result = numbers.stream()
				.takeWhile(number -> number < 5)
				.collect(Collectors.toList());

		System.out.println("Take elements till they are less than five: " + result);
	}

	private static void dropWhileExample(List<Integer> numbers) {
		List<Integer> result = numbers.stream()
				.dropWhile(number -> number < 5)
				.collect(Collectors.toList());

		System.out.println("Drop elements till they are less than five: " + result);
	}

	private static void ofNullableExample(List<Integer> numbers) {
		Stream<List<Integer>> stream = Stream.ofNullable(numbers);
		System.out.println("Values of Stream.ofNullable(numbers):");
		stream.forEach(System.out::println);

		System.out.println("Values of Stream.ofNullable(null):");
		stream = Stream.ofNullable(null);
	}

	private static void iterateExample() {
		Stream.iterate(1,  number -> number < 10,  number -> number + 2)
				.filter(number -> 0 == number % 3)
				.forEach(System.out::println);
	}
}
