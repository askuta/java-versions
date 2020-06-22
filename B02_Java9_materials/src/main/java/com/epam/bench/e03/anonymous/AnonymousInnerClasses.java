package com.epam.bench.e03.anonymous;

public class AnonymousInnerClasses {

	public static void main(String[] args) {
		MyAbstractClass<String> object = new MyAbstractClass<>() {

			@Override
			String doSomething(String a, String b) {
				return a + " " + b;
			}
		};

		System.out.println(object.doSomething("Concatenate", "strings."));
	}
}
