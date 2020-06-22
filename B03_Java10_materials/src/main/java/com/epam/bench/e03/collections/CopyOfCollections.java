package com.epam.bench.e03.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CopyOfCollections {

	public static void main(String[] args) {
		List<String> nameList = Stream.of("Jack", "Jill", "Taszilo").collect(Collectors.toCollection(ArrayList::new));
		Set<String> nameSet = Stream.of("Jack", "Jill", "Taszilo").collect(Collectors.toCollection(HashSet::new));
		Map<String, String> nameMap = new HashMap<>();
		nameMap.put("key1", "Jack");
		nameMap.put("key2", "Jill");
		nameMap.put("key3", "Taszilo");

		printTheCopyOfList(nameList);
		printTheCopyOfSet(nameSet);
		printTheCopyOfMap(nameMap);
	}

	private static void printTheCopyOfList(List<String> names) {
		List<String> copy = List.copyOf(names);
		// copy.add("asdf"); <-- UnsupportedOperationException
		System.out.println("Copy of list: " + copy);
	}

	private static void printTheCopyOfSet(Set<String> names) {
		Set<String> copy = Set.copyOf(names);
		// copy.add("asdf"); <-- UnsupportedOperationException
		System.out.println("Copy of set: " + copy);
	}

	private static void printTheCopyOfMap(Map<String, String> names) {
		Map<String, String> copy = Map.copyOf(names);
		// copy.put("key4", "asdf"); <-- UnsupportedOperationException
		System.out.println("Copy of map: " + copy);
	}
}
