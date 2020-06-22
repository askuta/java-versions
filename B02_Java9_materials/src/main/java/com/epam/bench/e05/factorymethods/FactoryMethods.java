package com.epam.bench.e05.factorymethods;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoryMethods {

	public static void main(String[] args) {
		createImmutableLists();
		createImmutableSets();
		createImmutableMaps();
	}

	private static void createImmutableLists() {
		List.of();
		List.of("qwer", "asdf");
	}

	private static void createImmutableSets() {
		Set.of();
		Set.of("qwer", "asdf");
	}

	private static void createImmutableMaps() {
		Map.of();
		Map.of("key1", "qwer", "key2", "asdf");
		Map.ofEntries(Map.entry("key1", "qwer"), Map.entry("key2", "asdf"));
	}
}
