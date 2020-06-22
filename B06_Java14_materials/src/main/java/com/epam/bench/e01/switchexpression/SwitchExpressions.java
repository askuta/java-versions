package com.epam.bench.e01.switchexpression;

public class SwitchExpressions {

	public static void main(String[] args) {
		switchExampleOldStyle("Wednesday");
		switchExampleNewYieldSyntax("Friday");
	}

	private static void switchExampleOldStyle(String day) {
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
			result = "You should learn more about days";
		}

		System.out.println(day + " is " + result);
	}

	@SuppressWarnings("preview")
	private static void switchExampleNewYieldSyntax(String day) {
		String result = switch (day) {
		case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "weekday";
		case "Saturday", "Sunday" -> "weekend";
		default -> "You should learn more about days";
		};

		System.out.println(day + " is " + result);
	}
}
