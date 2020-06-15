package com.epam.bench.e06.counters;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderCounterThread implements Runnable {

	public static LongAdder longAdder = new LongAdder();

	private final int iterations;
	private final int threadCount;

	public LongAdderCounterThread(int iterations, int threadCount) {
		this.iterations = iterations;
		this.threadCount = threadCount;
	}

	@Override
	public void run() {
		for (int i = 0; i < iterations / threadCount; i++) {
			longAdder.increment();
		}
	}
}
