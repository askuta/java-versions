package com.epam.bench.e04.stringtofile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadWriteString {

	public static void main(String[] args) throws IOException {
		Path path = Path.of("file", "txt");
		String str = "qwer";

		Files.writeString(path, str);
		Files.readString(path);
	}
}
