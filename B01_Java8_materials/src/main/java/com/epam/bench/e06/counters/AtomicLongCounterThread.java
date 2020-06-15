package com.epam.bench.e06.counters;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongCounterThread implements Runnable {

	public static final AtomicLong atomicLongCounter = new AtomicLong();

	private final int iterations;
	private final int threadCount;

	public AtomicLongCounterThread(int iterations, int threadCount) {
		this.iterations = iterations;
		this.threadCount = threadCount;
	}

	@Override
	public void run() {
		for (int i = 0; i < iterations / threadCount; i++) {
			atomicLongCounter.incrementAndGet();
		}
	}
}
