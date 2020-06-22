package com.epam.bench.e03.nestedclass;

import java.lang.reflect.Method;

public class NestedClassAccessControl {

	private MyNestedClass nestedObj = new MyNestedClass();

	public static void main(String[] args) throws Exception {
		Runtime.Version version = Runtime.version();
		System.out.println("Current version is " + version);

		NestedClassAccessControl obj = new NestedClassAccessControl();
		obj.nestedObj.innerPublicMethod();

		System.out.println("\n");

		obj.nestedObj.innerPublicMethodWithReflection();
	}

	public void outerPublicMethod() {
		System.out.println("I'm a public method in the outer class.");
	}

	private void outerPrivateMethod() {
		System.out.println("I'm a private method in the outer class.");
	}

	class MyNestedClass {

		public void innerPublicMethod() {
			System.out.println("I'm a public method in the nested class.");
			outerPrivateMethod();
		}

		public void innerPublicMethodWithReflection() throws Exception {
			System.out.println("I'm a public method in the nested class, call private method in the outer class with reflection.");
			NestedClassAccessControl obj = NestedClassAccessControl.this;
			// This would throw an Exception before Java 11:
			//    java.lang.IllegalAccessException: Class com.epam.NestedClassAccessControl$MyNestedClass
			//    can not access a member of class com.epam.NestedClassAccessControl with modifiers "private"
			Method method = obj.getClass().getDeclaredMethod("outerPrivateMethod");
			method.invoke(obj);
		}
	}
}
