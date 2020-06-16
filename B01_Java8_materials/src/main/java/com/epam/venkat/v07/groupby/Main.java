package com.epam.venkat.v07.groupby;

import java.util.Arrays;
import java.util.List;

import com.epam.venkat.Gender;
import com.epam.venkat.Person;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		List<Person> people = createPeople();

		groupPeopleByTheirName(people);
		groupAgesByName(people);
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

	private static void groupPeopleByTheirName(List<Person> people) {
		// Create a map of people where name is the key
		// and value is all the people with that name.
		System.out.println(people.stream()
				.collect(groupingBy(Person::getName)));
	}

	private static void groupAgesByName(List<Person> people) {
		// Create a map of people where name is the key
		// and value is all the ages of people with that name.
		System.out.println(people.stream()
				.collect(groupingBy(Person::getName,
						mapping(Person::getAge, toList()))));
	}
}
