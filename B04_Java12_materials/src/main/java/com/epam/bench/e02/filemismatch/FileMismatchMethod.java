package com.epam.bench.e02.filemismatch;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMismatchMethod {

	public static void main(String[] args) throws IOException, URISyntaxException {
		Path filePath1 = getPathOfResourceFile("file1.txt");
		Path filePath2 = getPathOfResourceFile("file2.txt");
		Path filePath3 = getPathOfResourceFile("file3.txt");

		System.out.println("Identical files result minus one: " + Files.mismatch(filePath1, filePath2));
		System.out.println("Different files result the first different byte: " + Files.mismatch(filePath1, filePath3));
	}

	private static Path getPathOfResourceFile(String file) throws URISyntaxException {
		URL url = FileMismatchMethod.class.getClassLoader().getResource(file);
		return Paths.get(url.toURI());
	}
}
