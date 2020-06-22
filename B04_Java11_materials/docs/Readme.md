Java 11 material
================

New syntax for lambda parameters
--------------------------------

- since Java 11, we can use var in lambdas
  - old syntax: (n, m) -> n * m
  - new syntax: (var n, var m) -> n * m
  - this feature gives uniformity with local variables, even if the extra syntax isn't necessary
  - also it make it possible to use annotations in lambdas:
    (@Nonnull var n, @Nullable var m) -> n * m

Standardizing the HTTP client
-----------------------------

- incubated API has been removed
- standard API: java.net.http
- the API is the same, but the implementation is completely different
  - completely asynchronous
  - Rx flow concepts have been moved to implementation
  - the flow of data can be more easily traced

Garbage collectors
------------------

- new garbage collectors
  - Epsilon:
    - a low-overhead garbage collector without any actual memory reclamation mechanism
    - without reclaiming memory, the Java heap will run out of memory and the JVM will exit
    - it is kind of useless
    - but if you want to implement your own garbage collector, Epsilon provides a reference
      implementation to you
    - advantage for memory pressure and performance testing
  - Scalable Low-Latency Z Garbage Collector:
    - reduces the length of pauses and handles various heap sizes
    - lays the foundation for future GC features and optimizations
    - only works on Linux for now, but could provide a huge boost to Java performance

Launch single-file source-code programs
---------------------------------------

- makes it possible to execute Java source code directly using the Java interpreter
- Java Launcher: launch a class file, main class of a JAR file, main class of a module, and now
  launch a class declared in an SRC file
- the source code is compiled in the memory and executed by the interpreter:
  > java <file_name>.java [arguments]
- limitations:
  - must be a single-file program
  - all code must fit in a single source file
  - all classes must be defined in one file
- good for beginners, small utility programs of to try new features

Java Flight Recorder
--------------------

- troubleshoot with APIs for producing and consuming events
- create, configure and filter events
- records events coming from applications, the JVM and the OS with Flight Recorder
- inspect events using Java Mission Control
- continuous with dump on demand:
  > java -XX:StartFlightRecording=settings=default
- continuous with dump on exit:
  > java -XX:StartFlightRecording=settings=default -XX:FlightRecorderOptions=dumponexit=true,dumponexitpath=C:\dump
- produce and consume custom flight recorder events with the class:
  jdk.jfr.Event
- create a custom event by creating a class that extends the class:
  jdk.jfr.Event
  instantiating it in your program, and calling the commit method on that instance
- causes minimal overhead on JVM performance
- reduces the developer community dependence on third-party tools and profilers

Security updates
----------------

- RFC 7784 scheme is much more efficient than the existing Elliptic Curve Diffie-Hellman (ECDH)
  scheme
- this feature brings an API for this new standard as well as a Java implementation that is
  platform-independent
- Transport Layer Security (TLS) 1.3
  - major overhaul of the TLS protocol
  - enhances security and performance significantly
  - no new public API
  - keep language competitive and up-to-date
- Cryptography updates:
  - Java 11 brings implementations of ChaCha20 and ChaCha20-Poly1305 cryptography algorithms
  - ChaCha20: relatively new stream cipher that replaces older, insecure RC4 cipher
  - cheaper to run on CPUs than AES (Advanced Encryption Standard) and is widely used in TLS

Java virtual machine (JVM) improvements
---------------------------------------

- Dynamic Class File Constants
  - extends the Java class file format to support a new constant pool form
  - important for compiler implementers and language designers
- Nest-Based Access Control
  - if you nest multiple classes, they can access each other's private data
  - no longer need to rely on access bridges
  - this improves performance for standard math functions as well as strings and arrays

Java 11 deprecations and housekeeping
-------------------------------------

- deprecated Nashorn JavaScript engine
  - it was too difficult to maintain considering the changes in ECMAScript
- deprecated Pack200 tools
  - often used for compressing jar files
  - Java 9 compression schemes make it obsolete
- Java EE and CORBA modules have now been removed completely
- updates made to ensure support for Unicode 10
