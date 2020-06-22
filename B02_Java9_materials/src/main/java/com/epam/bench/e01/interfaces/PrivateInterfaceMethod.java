package com.epam.bench.e01.interfaces;

public class PrivateInterfaceMethod implements Message {

	public static void main(String[] args) {
		PrivateInterfaceMethod obj = new PrivateInterfaceMethod();
		obj.message("is possible since Java 9");
	}
}
