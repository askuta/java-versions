package com.epam.bench.e01.strings;

public class StringMethods {

	public static void main(String[] args) {
		isBlankMethodExample();
		linesMethodExample();
		stripMethodExamples();
		repeatMethodExample();
	}

	private static void isBlankMethodExample() {
		System.out.println(".isBlank():\n");
		System.out.println("'qwer' is blank: " + "qwer".isBlank());
		System.out.println("'' is blank: " + "".isBlank());
		System.out.println("' ' is blank: " + " ".isBlank());
		System.out.println("'\\t' is blank: " + "\t".isBlank());
		System.out.println("'\\n' is blank: " + "\n".isBlank());
	}

	private static void linesMethodExample() {
		System.out.println("\n\n.lines():\n");
		String str = "qwer\nasdf\nyxcv";
		str.lines().forEach(System.out::println);
	}

	private static void stripMethodExamples() {
		// .strip() supports Unicode chareacters, .trim() doesn't
		System.out.println("\n\n.strip():\n");
		String str = "\n qwer \t";
		System.out.println("'\\n qwer \\t': '" + str + "'");
		System.out.println("'\\n qwer \\t'.strip(): '" + str.strip() + "'");
		System.out.println("'\\n qwer \\t'.stripLeading(): '" + str.stripLeading() + "'");
		System.out.println("'\\n qwer \\t'.stripTrailing(): '" + str.stripTrailing() + "'");
	}

	private static void repeatMethodExample() {
		System.out.println("\n\n.repeat(int):\n");
		System.out.println("\"qwer|\".repeat(3): '" + "qwer|".repeat(3) + "'");
	}
}
