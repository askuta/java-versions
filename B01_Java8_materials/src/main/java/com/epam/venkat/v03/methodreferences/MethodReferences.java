package com.epam.venkat.v03.methodreferences;

import java.util.Arrays;
import java.util.List;

public class MethodReferences {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		passingParameterToAnInstanceMethod(numbers);
		passingParameterToAStaticMethod(numbers);
		callMethodOnAParameter(numbers);

		passingTwoParameters(numbers);
		passingTwoParametersOneIsAMethod(numbers);
	}

	private static void passingParameterToAnInstanceMethod(List<Integer> numbers) {
		numbers.forEach(number -> System.out.println(number));

		numbers.forEach(System.out::println);
	}

	private static void passingParameterToAStaticMethod(List<Integer> numbers) {
		numbers.stream()
				.map(number -> String.valueOf(number))
				.forEach(System.out::println);

		numbers.stream()
				.map(String::valueOf) // <--
				.forEach(System.out::println);
	}

	private static void callMethodOnAParameter(List<Integer> numbers) {
		numbers.stream()
				.map(number -> String.valueOf(number))
				.map(str -> str.toString())
				.forEach(System.out::println);

		numbers.stream()
				.map(number -> String.valueOf(number))
				.map(String::toString) // <--
				.forEach(System.out::println);
	}

	private static void passingTwoParameters(List<Integer> numbers) {
		System.out.println("Sum: " + numbers.stream()
				.reduce(0, (total, number) -> Integer.sum(total, number)));

		System.out.println("Sum: " + numbers.stream()
				.reduce(0, Integer::sum));
	}

	private static void passingTwoParametersOneIsAMethod(List<Integer> numbers) {
		System.out.println("Concat: " + numbers.stream()
				.map(String::valueOf)
				.reduce("", (carry, str) -> carry.concat(str)));

		System.out.println("Concat: " + numbers.stream()
				.map(String::valueOf)
				.reduce("", String::concat));
	}
}
