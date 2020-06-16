package com.epam.venkat.v01.lambdas;

public class Lambdas {

	public static void main(String[] args) {
		createAThreadWithAnonymousInnerClass();
		createAThreadWithLambda();
	}

	private static void createAThreadWithAnonymousInnerClass() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("In another thread");
			}
		});
		thread.start();

		System.out.println("In main thread");
	}

	private static void createAThreadWithLambda() {
		Thread thread = new Thread(() -> System.out.println("In another thread (lambda)"));
		thread.start();

		System.out.println("In main thread (lambda)");
	}
}
