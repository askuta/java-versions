package com.epam.bench.e05.collectors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectUnmodifiableCollections {

	public static void main(String[] args) {
		collectUnmodifiableList();
		collectUnmodifiableSet();
		collectUnmodifiableMap();
	}

	private static void collectUnmodifiableList() {
		List<Integer> oddNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
				.filter(number -> 1 == number % 2)
				.collect(Collectors.toUnmodifiableList());

		// oddNumbers.add(11); <-- UnsupportedOperationException
		System.out.println("Odd numbers: " + oddNumbers);
	}

	private static void collectUnmodifiableSet() {
		Set<Integer> oddNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
				.filter(number -> 1 == number % 2)
				.collect(Collectors.toUnmodifiableSet());

		// oddNumbers.add(11); <-- UnsupportedOperationException
		System.out.println("Odd numbers: " + oddNumbers);
	}

	private static void collectUnmodifiableMap() {
		Map<String, Integer> oddNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
				.filter(number -> 1 == number % 2)
				.collect(Collectors.toUnmodifiableMap(String::valueOf, Integer::valueOf));

		// oddNumbers.put(11); <-- UnsupportedOperationException
		System.out.println("Odd numbers: " + oddNumbers);
	}
}
