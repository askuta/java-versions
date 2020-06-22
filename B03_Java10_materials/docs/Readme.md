Java 10 material
================

- JSR: Java Specification Request
- JEP: JDK Enhancement Proposal
- JAR: Java Archive

Local variable type inference
-----------------------------

Local variable type inference means that you can declare variables without having to specify the
associated type.

- adds syntactic sugar to Java
- reduces the verboseness in writing Java code
- keeps Java type-safe
- Java is still a statically typed language: once the type is assigned, you cannot change it
- var is not a keyword; it is a reserved type name or context-sensitive keyword
- code that uses var as a variable, method or package name will not be affected
- code that uses var as a class or interface name will be affected
- local variable type inference will be restricted to:
  - initializers:
    var myName = "Kathryn";
  - indexes in enhanced for-loops:
    for (var s : myArray) {...}
  - local variables initialized in traditional for-loops:
    for (var i = 0; i < 10; i++) {...}
- you must initialize variables, you cannot just declare them:
  - var x; <-- doesn't work
  - not available for method parameters, constructor parameters, method return types, fields, catch
    formats or any other variable declaration

Garbage collection improvements
-------------------------------

- they introduced the Garbage Collector Interface:
  - increases the code isolation of different garbage collectors
  - makes it easier to exclude a garbage collector from a JDK build
  - makes it easier to add a new garbage collector without affecting the code base
- the Full Garbage Collector is Parallel in Java 10
  - you can use it with the -XX:ParallelGCThreads option

Memory allocation to alternative devices
----------------------------------------

HotSpot VM:
- core component of the Java SE Platform: implements the JVM specification, accessible as a shared
  library
- provides runtime facilities, including dynamic compilers
- manages the Java heap and provides data to debugging tools

Why is this good?
- non-volatile dual in-line memory (NV-DIMM) is becoming cheaper
- this means future systems may have heterogeneous architectures, which will have dynamic random
  access memory (DRAM) and non-DRAM memory
- alternative memory devices can be used instead for the object heap without change to the existing
  code

Application class-data sharing
------------------------------

- CDS stands for Class Data Sharing
- it allows for a set of classes to be pre-processed into a shared archive file

Why is CDS good?
- each time the JVM loads a class it must do a bunch of work
- certain classes are included in Java by default
- creating a shared archive with these pre-processes classes reduces startup time and memory
  footprint if multiple JVMs share the same archive file

Root certificates
-----------------

- JDK was created in close collaboration with the OpenJDK
- the goal of this feature is to open-source the root certificates in Oracle Java SE, making
  OpenJDK builds more appealing to developers
- this feature also continues to reduce the differences between JDK and OpenJDK builds
- Cacerts TrustStore file found in ${JAVA_HOME}/lib/security
- this is where Java stores public certificates of root CAs
- Java uses cacerts to authenticate servers
- before, OpenJDK left the cacerts file empty
- in Java 10, the cacerts KeyStore will have certificates from the Oracle JDK issued by the
  Java SE Root CA program
- each certificate must sign the Oracle Contributor Agreement (OCA) to grant Oracle the right to
  open-source their certificates
- each certificate authority must confirm that they don't mind open-sourcing these certificates in
  OpenJDK repositories even if those certificates are already public
- reduce the differences between OpenJDK and JDK builds
- continue to make OpenJDK builds more appealing to developers
- make critical security pieces like TLS work by default in OpenJDK builds

Thread-local handshakes
-----------------------

- this feature introduces a way to execute a callback on threads without performing a global VM
  safepoint
- this makes it possible and cheap to stop individual threads, laying the groundwork for improved
  VM performance
- the callback is the handshake
- the handshake operation is the callback that is executed for each Java thread while that thread
  is in a safepoint-safe state
- executed by the thread itself or by the VM thread, keeping the thread in a blocked state
- the VM thread will coordinate the handshake operation through a VM operation, preventing global
  safepoints from occurring

Time-based release versioning
-----------------------------

- version counter:
  $FEATURE.$INTERIM.$UPDATE.$PATCH
- Feature-Release counter:
  - incremented for every feature release
  - features could be added or removed; if removed, advanced notice is given
  - $FEATURE used to be called $MAJOR
- Interim-Release counter:
  - incremented for non-feature releases
  - non-feature releases may contain compatible bug fixes and enhancements, but no incompatible
    changes, no feature removals, and no changes to the standard APIs
  - $INTERIM used to be called $MINOR
- Update-Release counter:
  - incremented for compatible update releases
  - these releases fix security issues, regressions, and bugs in newer features
  - $UPDATE used to be called $SECURITY
- Emergency Patch-Release counter:
  - incremented only when it's necessary to produce an emergency release to fix a critical issue
  - this additional element minimizes disruption to both developers and users of in-flight update
    releases
  - later elements are reserved for use by downstream consumers of the JDK code base
- the Runtime.Version API was updated with two new system properties:
  - java.version.date
  - java.vendor.version

Experimental Java-based just-in-time (JIT) compiler
---------------------------------------------------

- the HotSpot JVM has two JITs:
  - C1: fast, simple, less optimization, good for quick startup
  - C2: slower, more optimization, good for long-running server apps
- Graal is another JIT for Java
  - written in Java to compile Java bytecode
  - Graal was added in Java 9, but now we can enable it with:
    -XX:+UnlockExperimentalVMOptions -XX:+UseJVMCICompiler
  - it's in an experiment stage, you should not use it for production

Other housekeeping updates
--------------------------

- consolidate the JDK forest:
  - combined numerous repositories of the JDK forest into single repository
  - simplified and streamlined development
- remove javah, the native-header generation tool
  - it lived in ${JAVA_HOME}/bin
- additional Unicode language-tag extensions
  - enhanced java.util.Locale and related APIs
  - made it possible to implement addition Unicode extensions of language syntax
