package com.epam.bench.e01.swithcexpressions;

public class SwitchExpressions {

	public static void main(String[] args) {
		switchExampleOldStyle("Wednesday");

		// New Switch Expression syntax is a preview feature
		// switchExampleNewBreakSyntax("Wednesday");
		// switchExampleNewCaseSyntax("Wednesday");
	}

	private static String switchExampleOldStyle(String day) {
		String result;
		switch (day) {
		case "Monday":
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
		case "Friday": {
			result = "weekday";
			break;
		}
		case "Saturday":
		case "Sunday": {
			result = "weekend";
			break;
		}
		default:
			result = "You should learn about days";
		}

		return result;
	}

/*
	// New Switch Expression syntax is a preview feature!

	private static String switchExampleNewBreakSyntax(String day) {
		String result = switch (day) {
		case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday":
			break "weekday";
		case "Saturday", "Sunday":
			break "weekend";
		default:
			break "You should learn about days";
		};

		return result;
	}

	private static String switchExampleNewCaseSyntax(String day) {
		String result = switch (day) {
		case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "weekday";
		case "Saturday", "Sunday" -> "weekend";
		default -> "You should learn about days";
		};

		return result;
	}
*/
}
