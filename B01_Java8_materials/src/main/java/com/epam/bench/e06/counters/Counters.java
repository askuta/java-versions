package com.epam.bench.e06.counters;

import java.util.ArrayList;
import java.util.List;

public class Counters {

	private static final int THREAD_COUNT = 4;
	private static final int ITERATIONS = 100_000_000;

	public static void main(String[] args) throws InterruptedException {
		testLongAdderCounterThread();
		testAtomicLongCounterThread();
		testSimpleLongCounterThread();
	}

	private static void testLongAdderCounterThread() throws InterruptedException {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads.add(new Thread(new LongAdderCounterThread(ITERATIONS, THREAD_COUNT)));
		}

		runThreads(threads);
		System.out.println("Accumulator: " + LongAdderCounterThread.longAdder);
	}

	private static void testAtomicLongCounterThread() throws InterruptedException {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads.add(new Thread(new AtomicLongCounterThread(ITERATIONS, THREAD_COUNT)));
		}

		runThreads(threads);
		System.out.println("AtomicLong: " + AtomicLongCounterThread.atomicLongCounter);
	}

	private static void testSimpleLongCounterThread() throws InterruptedException {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads.add(new Thread(new SimpleLongCounterThread(ITERATIONS, THREAD_COUNT)));
		}

		runThreads(threads);
		System.out.println("Long counter: " + SimpleLongCounterThread.longCounter);
	}

	private static void runThreads(List<Thread> threads) throws InterruptedException {
		long start = System.currentTimeMillis();

		threads.forEach(thread -> thread.start());

		for (Thread thread : threads) {
			thread.join();
		}

		long end = System.currentTimeMillis();
		System.out.println("\nTime: " + (end - start) + " ms");
	}
}
