package com.epam.bench.e04.optional;

import java.util.Optional;

public class OptionalOrElseThrow {

	public static void main(String[] args) {
		Optional<String> optional = Optional.ofNullable("Tohotom");
		String name = optional.orElseThrow(); // preferred, equivalent to get()
		System.out.println("Name: " + name);

		optional = Optional.ofNullable(null);
		// name = optional.orElseThrow(); <-- null would throw a NoSuchElementException
	}
}
