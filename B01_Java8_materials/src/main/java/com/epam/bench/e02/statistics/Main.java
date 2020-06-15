package com.epam.bench.e02.statistics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Transaction> transactions = readTransactions();

		printMaxPrice(transactions);
		printSumOfPrices(transactions);
		printSumOfPricesInSacramento(transactions);
		printStreetOfTheHighestPrice(transactions);
		printTransactionsInCitrusHeights(transactions);
		printTheFirstTransactionsInCitrusHeights(transactions);
		printTheSortedFiveMostExpensiveTransactions(transactions);
	}

	private static List<Transaction> readTransactions() throws IOException, FileNotFoundException {
		List<Transaction> transactions = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new FileReader(Main.class.getClassLoader().getResource("transactions.csv").getFile()))) {
			reader.readNext();
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				Transaction transaction = createTransaction(nextLine);
				transactions.add(transaction);
			}
		}

		return transactions;
	}

	private static Transaction createTransaction(String[] nextLine) {
		Transaction transaction = new Transaction();
		transaction.setStreet(nextLine[0]);
		transaction.setCity(nextLine[1]);
		transaction.setState(nextLine[2]);
		transaction.setBeds(Integer.valueOf(nextLine[3]));
		transaction.setBaths(Integer.valueOf(nextLine[4]));
		transaction.setFloorArea(Integer.valueOf(nextLine[5]));
		transaction.setType(nextLine[6]);
		transaction.setPrice(Integer.valueOf(nextLine[7]));

		return transaction;
	}

	private static void printMaxPrice(List<Transaction> transactions) {
		System.out.println("\nCalculate max price with different approaches:");

		OptionalInt maxPriceInt = transactions.stream()
				.mapToInt(transaction -> transaction.getPrice())
				.max();
		System.out.println("\n\tMax price: " + maxPriceInt.getAsInt());

		Optional<Integer> maxPriceInteger = transactions.stream()
				.map(transaction -> transaction.getPrice())
				.max(Integer::compare);
		System.out.println("\tMax price: " + maxPriceInteger.get());

		Optional<Transaction> transactionWithMaxPrice = transactions.stream()
				.max((transaction1, transaction2) -> Integer.compare(transaction1.getPrice(), transaction2.getPrice()));
		System.out.println("\tMax price: " + transactionWithMaxPrice.get().getPrice());
	}

	private static void printSumOfPrices(List<Transaction> transactions) {
		System.out.println("\n\nCalculate sum of prices with different approaches:");
		int sum = transactions.stream()
				.mapToInt(transaction -> transaction.getPrice())
				.sum();
		System.out.println("\n\tSum of prices: " + sum);

		int sumWithBinaryOperator = transactions.stream()
				.mapToInt(transaction -> transaction.getPrice())
				.reduce(0, new IntBinaryOperator() {

					@Override
					public int applyAsInt(int left, int right) {
						return left + right;
					}
				});
		System.out.println("\tSum of prices: " + sumWithBinaryOperator);

		int sumWithReduce = transactions.stream()
				.mapToInt(transaction -> transaction.getPrice())
				.reduce(0, (value1, value2) -> value1 + value2);
		System.out.println("\tSum of prices: " + sumWithReduce);
	}

	private static void printSumOfPricesInSacramento(List<Transaction> transactions) {
		System.out.println("\n\nCalculate sum of prices in Sacramento:");
		int sum = transactions.stream()
				.filter(transaction -> transaction.getCity().equalsIgnoreCase("Sacramento"))
				.mapToInt(transaction -> transaction.getPrice())
				.sum();
		System.out.println("\n\tSum of prices in Sacramento: " + sum);
	}

	private static void printStreetOfTheHighestPrice(List<Transaction> transactions) {
		System.out.println("\n\nSearch the street of the highest price:");
		String street = transactions.stream()
				.max((transaction1, transaction2) -> Integer.compare(transaction1.getPrice(), transaction2.getPrice())).get().getStreet();
		System.out.println("\n\tStreet of the highest price: " + street);
	}

	private static void printTransactionsInCitrusHeights(List<Transaction> transactions) {
		System.out.println("\n\nPrint transactions in Citrus Heights above 250000 price:\n");
		transactions.stream()
				.forEach(new Consumer<Transaction>() {

					@Override
					public void accept(Transaction transaction) {
						if ("Citrus Heights".equalsIgnoreCase(transaction.getCity()) && transaction.getPrice() > 250000) {
							System.out.println(transaction);
						}
					}
				});

		System.out.println("\n\nPrint transactions in Citrus Heights above 250000 price:\n");
		transactions.stream()
				.filter(transaction -> "Citrus Heights".equalsIgnoreCase(transaction.getCity()))
				.filter(transaction -> transaction.getPrice() > 250000)
				.forEach(System.out::println);
	}

	private static void printTheFirstTransactionsInCitrusHeights(List<Transaction> transactions) {
		System.out.println("\n\nThe first transactions in Citrus Heights above 250000 price:\n");
		transactions.stream()
				.filter(transaction -> "Citrus Heights".equalsIgnoreCase(transaction.getCity()))
				.filter(transaction -> transaction.getPrice() > 250000)
				.findFirst()
				.ifPresent(System.out::println);;
	}

	private static void printTheSortedFiveMostExpensiveTransactions(List<Transaction> transactions) {
		System.out.println("\n\nThe five most expensive transactions ordered by price:\n");
		List<Transaction> topTransactions = transactions.stream()
				.sorted((transaction1, transaction2) -> -Integer.compare(transaction1.getPrice(), transaction2.getPrice()))
				.limit(5)
				.collect(Collectors.toList());
		System.out.println("\tTop transactions: " + topTransactions);
	}
}
