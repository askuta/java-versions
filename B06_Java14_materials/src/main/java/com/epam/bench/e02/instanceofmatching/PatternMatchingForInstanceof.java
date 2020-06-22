package com.epam.bench.e02.instanceofmatching;

public class PatternMatchingForInstanceof {

	public static void main(String[] args) {
		instanceofOldStyle("This is a String object.");
		instanceofNewStyle("This is a String object.");
	}

	private static void instanceofOldStyle(Object obj) {
		if (obj instanceof String) {
			String str = (String) obj;
			System.out.println("'obj' parameter was a String: " + str.toUpperCase());
		}
	}

	private static void instanceofNewStyle(Object obj) {
//		if (obj instanceof String str) {
//			System.out.println("'obj' parameter was a String: " + str.toUpperCase());
//		}
	}
}
