package com.epam.bench.e06.processapi;

public class ProcessApi {

	public static void main(String[] args) {
		ProcessHandle processHandle = ProcessHandle.current();
		System.out.println("Process Id: " + processHandle.pid());
		System.out.println("Direct children: " + processHandle.children());
		System.out.println("Class name: " + processHandle.getClass());
		System.out.println("All processes: " + ProcessHandle.allProcesses());
		System.out.println("Process info: " + processHandle.info());
		System.out.println("Is process alive: " + processHandle.isAlive());
		System.out.println("Process's parent " + processHandle.parent());

		System.out.println("\n\nAll processes in detail:");
		ProcessHandle.allProcesses()
				.forEach(process -> System.out.println(process.info()));
	}
}
