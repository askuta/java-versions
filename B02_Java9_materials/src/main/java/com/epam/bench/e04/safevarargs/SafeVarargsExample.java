package com.epam.bench.e04.safevarargs;

import java.util.ArrayList;
import java.util.List;

public class SafeVarargsExample {

	public static void main(String[] args) {
		List<String> products = getProducts();

		SafeVarargsExample obj = new SafeVarargsExample();
		obj.displayProducts(products);
	}

	private static List<String> getProducts() {
		List<String> products = new ArrayList<>();
		products.add("Duck");
		products.add("Truck");

		return products;
	}

	@SafeVarargs
	private void displayProducts(List<String>... products) {
		for (List<String> product : products) {
			System.out.println(product);
		}
	}
}
