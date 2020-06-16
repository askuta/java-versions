package com.epam.venkat.v09.characteristics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Characteristics {

	public static void main(String[] args) {
		List<Integer> numberes = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

		example(numberes);
		iterateFromHundredToInfinite();

		int k = 20;
		int n = 51;
		compute(k, n);
		computeWithLambda(k, n);
	}

	private static void example(List<Integer> numberes) {
		numberes.stream()
				.sorted()
				.distinct()
				.filter(number -> 0 == number % 2)
				.forEach(System.out::println);
	}

	private static void iterateFromHundredToInfinite() {
		System.out.println(Stream.iterate(100, number -> number + 1));
	}

	private static void compute(int k, int n) {
		int result = 0;
		int index = k;
		int count = 0;
		while (count < n) {
			if (0 == index % 2 && Math.sqrt(index) > 20) {
				result += 2 * index;
				count++;
			}
			index++;
		}
		System.out.println("Result: " + result);
	}

	private static void computeWithLambda(int k, int n) {
		System.out.println("Result: " + Stream.iterate(k, number -> number + 1)
				.filter(number -> 0 == number % 2)
				.filter(number -> Math.sqrt(number) > 20)
				.mapToInt(number -> 2 * number)
				.limit(n)
				.sum());
	}
}
