package com.epam.bench.e06.counters;

public class SimpleLongCounterThread implements Runnable {

	public static volatile long longCounter = 0L;
	private static Object lock = new Object();

	private final int iterations;
	private final int threadCount;

	public SimpleLongCounterThread(int iterations, int threadCount) {
		this.iterations = iterations;
		this.threadCount = threadCount;
	}

	@Override
	public void run() {
		for (int i = 0; i < iterations / threadCount; i++) {
			synchronized (lock) {
				longCounter++;
			}
		}
	}
}
