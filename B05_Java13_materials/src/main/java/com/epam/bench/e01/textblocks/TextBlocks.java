package com.epam.bench.e01.textblocks;

public class TextBlocks {

	@SuppressWarnings("preview")
	public static void main(String[] args) {
		String multilineText = """
				This string
				contains
				multiple lines
				of text.""";

		String normalString = "This string\ncontains\nmultiple lines\nof text.";
		System.out.println("Multiline text: " + multilineText);
		System.out.println("\nNormal text: " + normalString);
		System.out.println("\nAre they equal: " + multilineText.equals(normalString));
	}
}
