package com.epam.bench.e02.varlambdaparam;

public class VarLambdaParameter {

	public static void main(String[] args) {
		String str = "qwer\nasdf\nyxcv";
		str.lines()
				// If you use 'var', you have to use it for every parameter
				.map((/*Annotations might come here*/ var string) -> "   ---===   " + string + "   ===---   ")
				.forEach(System.out::println);
	}
}
