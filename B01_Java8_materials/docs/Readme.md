Internal training
=================

Diamond Problem
---------------

Default methods are available since Java 8 that might create the diamond problem in the inheritance of multiple
interfaces. In these cases, classes must define which default method they apply or override the method:

  public class SecondLogger implements Logger, LoggerFacade {

    @Override
    public void log(Level level, String message) {
      LoggerFacade.super.log(level, message);
    }

    :
  }

Reflection
----------

Since Java 8, you can access parameter names if you check in:
  Window -> Preferences -> Java -> Compiler
    "Store information about method parameters (usable via reflection)"

You can add the same annotation to an interface/class twice if you use the annotation:
  @Repeatable

  @FilterNew("filter1")
  @FilterNew("filter2")
  public interface FilterableNew { }


Venkat
======

https://www.youtube.com/watch?v=1OpAgZvYXLQ

Lambdas
-------

- anonymous inner class --> lambda
- functional interface
- Java doesn't replace lambdas with anonymous inner classes during compile time
  - anonymous inner classes are compiled to .class files
  - some other JVM based languages replaces lambdas with anonymous inner classes
  - Java doesn't do it (because big .jar files, more memory, more objects, more garbage collection, more time, etc.)
  - Java uses invokedynamic for lambdas

Iterators
---------

- internal iterators take advantage of polymorphism
- Java 8 has type inference, but only for lambda expressions
- lambdas are glue code, don't write too many lines of code within them (only one line if possible)
- it's difficult to test lambdas, so extract more than one line of code to a method, write a test for the method and
  call the method from a lambda

Method references
-----------------

- only useful when you receive a parameter and pass it through to a method
- cannot use when instance and static methods collide

Streams
-------

- streams are sets of functions, they don't store data
- streams are non mutating pipelines that data flows through

Stream operations
-----------------

- filter: block some data in the stream/pipeline
  parameter: Stream<T> filter takes Predicate<T>
- map: transforms values; input type and output type can be different
  parameter: Stream<T> map takes Function<T, R> to return Stream<R>
- filter and map stay within their swimlanes:

      filter   map
  ----------------
  x1    |
  ----------------
  x2   ->      x2'
  ----------------
  x3    |
  ----------------
  x4   ->      x4'

- reduce cuts across the swimlanes; reduces stream to a single value
  parameter: Stream<T, BiFunction<R, T, R> to produce a result of R

      filter   map   reduce
                       0.0
  ----------------      \
  x1    |                \
  ----------------        \
  x2   ->      x2'         +
  ----------------          \
  x3    |                    \
  ----------------            \
  x4   ->      x4'             +

- specialized reduce functions:
  - sum
  - collect

Lazy evaluation
---------------

- intermediate operations: postpone evaluation (clean your room, turn off the tv)
  only build the pipeline but doesn't do anything
  return a Stream
- terminal operations: triggers the evaluation (call daddy)
  executes the pipeline
  return something that is not a Stream

Lazy evaluation is possible only if the functions don't have side effect (e.g. don't print comments or partial data).

Characteristics of streams
--------------------------

- sized / infinite
- ordered / unordered
- distinct / not distinct
- sorted / not sorted

Infinite streams cannot exist without laziness. Laziness cannot exist without NO side-effect. No side-effect cannot
exist without immutability.
