package com.epam.bench.e02.textblocks;

public class TextBlocksMethods {

	@SuppressWarnings("preview")
	private static final String TEXT_BLOCK = """
			Name: %s
			Address: %s
			Phone: %s
			Salary: $%.2f""";

	@SuppressWarnings("preview")
	private static final String HTML_TEXT_BLOCK = """
			<html>   \n
			    <head>
			    </head>\t
			    <body>
			    	<h1>This is highlighted with "quotes"</h1>
			    	Hiragana (in Japanese): \u3072\u3038\u304C\u306A
			    </body>
			</html>""";

	public static void main(String[] args) {
		formattedExample();
		stripIndentExample();
		translateEscapesExample();
	}

	@SuppressWarnings("removal")
	private static void formattedExample() {		System.out.println(TEXT_BLOCK.formatted("King Arthur", "England", "555-678", 123456.78));
	}

	@SuppressWarnings("removal")
	private static void stripIndentExample() {
		System.out.println("\n\n");
		HTML_TEXT_BLOCK.stripIndent().lines()
				.map(line -> "'" + line + "'")
				.forEach(System.out::println);;
	}

	@SuppressWarnings("removal")
	private static void translateEscapesExample() {
		System.out.println("\n\n");
		HTML_TEXT_BLOCK.translateEscapes().chars()
				.forEach(character -> System.out.print("" + Character.toString(character)));
	}
}
