package com.epam.bench.e05.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		URI imageUri = Main.class.getClassLoader().getResource("image.png").toURI();
		BufferedImage image = ImageIO.read(new File(imageUri));
		PixelStore pixels = readImage(image);

		long start = System.currentTimeMillis();
		int[] rgbArray = processImage(pixels);
		long end = System.currentTimeMillis();
		System.out.println("Image processing took for " + (end - start) + " milliseconds.");
		writeImage(image, rgbArray);
	}

	private static PixelStore readImage(BufferedImage image) {
		PixelStore pixels = new PixelStore(image.getWidth(), image.getHeight());
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int rgb = image.getRGB(x, y);
				pixels.add(rgb);
			}
		}

		return pixels;
	}

	private static int[] processImage(PixelStore pixels) {
		int[] rgbArray = pixels
				//.stream()
				.parallelStream()
				.map(pixel -> pixels.getAreaColor(pixel))
				.peek(pixel -> pixel.applySepia())
				.mapToInt(pixel -> pixel.toInt())
				.toArray();

		return rgbArray;
	}

	private static void writeImage(BufferedImage image, int[] rgbArray) throws IOException {
		BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		result.setRGB(0, 0, image.getWidth(), image.getHeight(), rgbArray, 0, image.getWidth());

		ImageIO.write(result, "jpg", new File("result.jpg"));
	}
}
