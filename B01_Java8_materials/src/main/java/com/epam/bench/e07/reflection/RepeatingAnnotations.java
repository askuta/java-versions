package com.epam.bench.e07.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatingAnnotations {

	// Old style

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface FiltersOld {
		FilterOld[] value();
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface FilterOld {
		String value();
	}

	@FiltersOld({ @FilterOld("filter1"), @FilterOld("filter2") })
	public interface FilterableOld {
	}

	// New style

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface FiltersNew {
		FilterNew[] value();
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(value = FiltersNew.class)
	public @interface FilterNew {
		String value();
	}

	@FilterNew("filter1")
	@FilterNew("filter2")
	public interface FilterableNew {
	}

	public static void main(String[] args) {
		FiltersOld filtersOld = FilterableOld.class.getAnnotation(FiltersOld.class);
		for (FilterOld filter : filtersOld.value()) {
			System.out.println(filter.value());
		}

		System.out.println();

		FiltersNew filtersNew = FilterableNew.class.getAnnotation(FiltersNew.class);
		for (FilterNew filter : filtersNew.value()) {
			System.out.println(filter.value());
		}
	}
}
