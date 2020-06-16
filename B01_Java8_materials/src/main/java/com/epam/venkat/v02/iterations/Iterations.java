package com.epam.venkat.v02.iterations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iterations {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		externalIteratorVersion1(numbers);
		externalIteratorVersion2(numbers);

		internalIteratorVersion1(numbers);
		internalIteratorVersion2(numbers);
		internalIteratorVersion3(numbers);
		internalIteratorVersion4(numbers);
		internalIteratorVersion5(numbers);
	}

	private static void externalIteratorVersion1(List<Integer> numbers) {
		for (int index = 0; index < numbers.size(); index++) {
			System.out.println(numbers.get(index));
		}
	}

	private static void externalIteratorVersion2(List<Integer> numbers) {
		for (int number : numbers) {
			System.out.println(number);
		}
	}

	private static void internalIteratorVersion1(List<Integer> numbers) {
		numbers.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer value) {
				System.out.println(value);
			}
		});
	}

	private static void internalIteratorVersion2(List<Integer> numbers) {
		numbers.forEach((Integer value) -> System.out.println(value));
	}

	private static void internalIteratorVersion3(List<Integer> numbers) {
		numbers.forEach((value) -> System.out.println(value));
	}

	private static void internalIteratorVersion4(List<Integer> numbers) {
		numbers.forEach(value -> System.out.println(value));
	}

	private static void internalIteratorVersion5(List<Integer> numbers) {
		numbers.forEach(System.out::println);
	}
}
