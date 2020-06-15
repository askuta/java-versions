package com.epam.bench.e04.dates;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

	public static void main(String[] args) {
		System.out.println("Today: " + LocalDate.now());
		System.out.println("Five days later: " + LocalDate.now().plusDays(5));
		System.out.println("Date of '2020.6.12': " + LocalDate.of(2020, 6, 12));
		System.out.println("The 164th day of '2020': " + LocalDate.ofYearDay(2020, 164));

		System.out.println("\nNow: " + LocalTime.now());
		System.out.println("\n20 minutes later: " + LocalTime.now().plusMinutes(20));
		System.out.println("Time of '15:30': " + LocalTime.of(15, 30));

		System.out.println("\nToday, now: " + LocalDateTime.now());
		System.out.println("Date and time of '2020.6.12 15:30': " + LocalDateTime.of(2020, 6, 12, 15, 30));

		System.out.println("\nCurrent time in 'New York': " + LocalTime.now(ZoneId.of("America/New_York")));
		System.out.println("Current UTC time: " + LocalTime.now(Clock.systemUTC()));

		System.out.println("\nToday, now with time zone: " + ZonedDateTime.now());
	}
}
