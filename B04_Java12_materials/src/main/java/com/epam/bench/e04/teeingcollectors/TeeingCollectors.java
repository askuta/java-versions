package com.epam.bench.e04.teeingcollectors;

import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.teeing;

import java.util.stream.Collectors;

public class TeeingCollectors {

	public static void main(String[] args) {
		System.out.println("Result of Collectors.summingDouble: "
				+ Stream.of(1, 2, 3, 4, 5).collect(Collectors.summingDouble(number -> number)));

		System.out.println("Result of Collectors.counting: "
				+ Stream.of(1, 2, 3, 4, 5).collect(Collectors.counting()));

		double mean = Stream.of(1, 2, 3, 4, 5)
				.collect(teeing(
						summingDouble(number -> number),
						counting(),
						(sum, count) -> sum / count));
		System.out.println(mean);
	}
}
