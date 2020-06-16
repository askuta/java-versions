package com.epam.venkat.v06.collecttomap;

import java.util.Arrays;
import java.util.List;

import com.epam.venkat.Gender;
import com.epam.venkat.Person;

import static java.util.stream.Collectors.toMap;

public class Main {

	public static void main(String[] args) {
		List<Person> people = createPeople();

		// Collect people to a map where "name-age" is the key
		// and person is the value.
		people.stream()
				.collect(toMap(person -> person.getName() + "-" + person.getAge(),
							   person -> person));
	}

	private static List<Person> createPeople() {
		return Arrays.asList(
				new Person("Sara", Gender.FEMALE, 20),
				new Person("Sara", Gender.FEMALE, 22),
				new Person("Bob", Gender.MALE, 20),
				new Person("Paula", Gender.FEMALE, 32),
				new Person("Paul", Gender.MALE, 32),
				new Person("Jack", Gender.MALE, 2),
				new Person("Jack", Gender.MALE, 72),
				new Person("Jill", Gender.FEMALE, 12));
	}
}
