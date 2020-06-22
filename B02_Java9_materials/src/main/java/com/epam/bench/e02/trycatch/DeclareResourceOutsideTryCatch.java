package com.epam.bench.e02.trycatch;

import java.io.PrintStream;

public class DeclareResourceOutsideTryCatch {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		PrintStream printStream = new PrintStream(System.out);
		try (printStream) {
			ALPHABET.chars()
					.map(Character::toUpperCase)
					.forEach(character -> printStream.write(character));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
