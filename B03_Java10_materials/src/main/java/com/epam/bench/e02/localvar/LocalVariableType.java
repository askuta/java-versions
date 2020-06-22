package com.epam.bench.e02.localvar;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableType {

	public static void main(String[] args) {
		// Before Java 10
		List<String> oldList = new ArrayList<>();
		int oldNumber = 42;
		String oldStr = "Java 9";
		System.out.println("Old: " + oldList + oldNumber + oldStr);

		// Since Java 10
		var newList = new ArrayList<String>();
		var newNumber = 42;
		var newStr = "Java 11";
		System.out.println("New: " + newList + newNumber + newStr);
	}
}
