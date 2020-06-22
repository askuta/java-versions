Java 12 material
================

JVM Changes
-----------

- Shenandoah Garbage Collector (Experimental)
  - a Low-Pause-Time Garbage Collector
  - runs GC concurrently with the running Java threads
  - consistent and predictable short pauses
  - irrelevant of the heap size
  - you can enable the Shenandoah GC:
    -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC
- Promptly Return Unused Committed Memory from G1
  - G1 now checks Java Heap memory during inactivity of application and return it to the operating
    system
- Abortable Mixed Collections for G1
  - improvements in G1 efficiency include making G1 mixed collections abortable if they might
    exceed the defined pause
  - this is done by splitting the mixed collection set into mandatory and optional
  - the G1 collector can prioritize on collecting the mandatory set first to meet the pause time
    goal
- Microbenchmark Suite
  - adds a basic suite of microbenchmarks to the JDK source code
  - this makes it easy for developers to run existing microbenchmarks and create new ones
- One AArch64 Port, Not Two
  - removes all of the sources related to the arm64 port while retaining the 32-bit ARM port and
    the 64-bit aarch64 port
  - this allows contributors to focus their efforts on a single 64-bit ARM implementation
- Default CDS Archives
  - enhances the JDK build process to generate a class data-sharing (CDS) archive, using the
    default class list, on 64-bit platforms
  - the goal is to improve startup time
  - from Java 12, CDS is by default ON
  - you can turn it off:
    > java -Xshare:off HelloWorld.java

Switch Expressions
------------------

  - Java 12 has enhanced Switch expressions for Pattern matching
  - Switch Expressions don’t fall through anymore
  - furthermore, we can define multiple constants in the same label
  - default case is now compulsory in Switch Expressions
  - break is used in Switch Expressions to return values from a case itself

File mismatch() Method
----------------------

  - compares two files
  - returns the position of the first mismatch or -1L if there is no mismatch

Compact Number Formatting
-------------------------

  - provides Locale based number formatting

Teeing Collectors in Stream API
-------------------------------

  - new collector utility introduced in the Streams API
  - has three arguments: two collectors and a Bi-function
  - all input values are passed to each collector and the result is available in the Bi-function

Java Strings New Methods
------------------------

  - indent: adjusts the indentation of each line in the string based on the value of 'n' and also
    normalizes line termination characters
  - transform: allows us to call a lambda function on the given string; the function should expect
    a single String argument and produce a result
  - describeConstable:
  - resolveConstantDesc:

JVM Constants API
-----------------

  - useful for those developers who use constants pool

Pattern Matching for instanceof
-------------------------------

  - a preview feature in Java 12
  if (str instanceof String s) {
    System.out.println(s.toUpperCase());
  }

Raw String Literals is Removed From JDK 12
------------------------------------------

  - Raw String Literals is Removed From JDK 12
