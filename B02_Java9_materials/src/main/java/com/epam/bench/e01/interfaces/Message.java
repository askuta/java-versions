package com.epam.bench.e01.interfaces;

public interface Message {

	default void message(String msg) {
		printMessage(msg);
		printMessageFromStaticMethod(msg);
	}

	private void printMessage(String msg) {
		System.out.println("Printing messages from a private interface method '" + msg + "'");
	}

	private static void printMessageFromStaticMethod(String msg) {
		System.out.println("Printing messages from a static private interface method '" + msg + "'");
	}
}
