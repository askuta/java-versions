package com.epam.bench.e05.stringmethods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewStringMethods {

	public static void main(String[] args) {
		indentExample();
		transformExample();
	}

	private static void indentExample() {
		String str = "qwer\n   asdf\n      yxcv";
		System.out.println("Without .indent():");
		System.out.println(str);

		// .indent(0) still normalize line terminators (\r is normalized to \n )
		System.out.println("\n\nWith .indent(0):");
		System.out.println(str.indent(0));

		System.out.println("\n\nWith .indent(-3):");
		System.out.println(str.indent(-3));

		System.out.println("\n\nWith .indent(3):");
		System.out.println(str.indent(3));
	}

	private static void transformExample() {
		String str = "qwer,asdf,yxcv";
		List<String> strList = str.transform(s -> {
				return Arrays.asList(s.split(","));
			});
		System.out.println("\n\nTransformed string list: " + strList);

		strList = str.transform(NewStringMethods::sortStrings)
				.collect(Collectors.toList());
		System.out.println("\n\nTransformed string to sorted list: " + strList);
	}

	private static Stream<String> sortStrings(String str) {
		return List.of(str.split(",")).stream().sorted();
	}
}
