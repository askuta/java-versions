package com.epam.bench.e06.optional;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

public class DescribeConstable {

	public static void main(String[] args) {
		describeConstableExample();
		resolveConstantDescExapmple();
	}

	private static void describeConstableExample() {
		String str = "I'm a string.";
		Optional<String> optionalStr = str.describeConstable();
		System.out.println(optionalStr);
		System.out.println(optionalStr.get());
	}

	private static void resolveConstantDescExapmple() {
		String str = "I'm a string.";
		String constantDesc = str.resolveConstantDesc(MethodHandles.lookup());
		System.out.println(constantDesc);
	}
}
