Internal training
=================

G1 is the default GC
====================

- G1 is available since Java 7, it was not stable
- no more permgen
- dynamically sized young and old generations
- GC is made in smaller granularity (a GC cycle not necessarily swipe everything at once)
- optated maximum Stop-the-World can be set


Java Platform Module System
===========================

- modules are higher level of encapsulation
- modules
  - require other modules for their work
  - export packages
  - use services and provide services
  - open packages for reflection
- service provision is an extension of ServiceLoader (available since 1.2, nobody used really)

JPMS does not:
  - OSGI
  - dynamically adding modules (well, not exactly)
  - handle different module version

JPMS does:
  - fail fast when a module is not there
  - different modules provide the same class... ops... not allowed
  - does not search the whole classpath including trillions of classes, only modules along dependency transitive
    closure (speed, speed, that is we hope)
  - more discipline for the developers not to touch private parts of the library


JShell
======

- JShell is a REPL (read, eval, print, loop) app
- start it up and play around with it, that it is for, nothing else


Language Changes
================

- you can have in an interface
  - method declarations
  - final static fields
  - nested classes
  - nested interface
- Java 8:
  - default methods
  - tatic methods
- Java 9:
  - private methods

You still cannot have instance fields.

Try-with-resources:
  - Java:
    - try - catch - finally
  - Java 7:
    - try (final Autocloseable x = open()) - catch - finally
  - Java 9:
    - Autocloseable x :- effectively final
    - try (x = open()) - catch - finally

We can use the <> for anonymous classes:
  <T> Box<T> createBox(T content) {
    // we have to put the 'T' here
    return new Box<T>(content) { };
  }

@SafeVarargs on private methods:
  - in Java 8 static and final methods could have the @SafeVarargs annotation
  - in Java 9 private method also can have it

NO warning for @Deprecated class import:
  - we get warning inside the classes anyway


New APIs
========

Process API:
  - Java 8: OS specific, tricks and workarounds
  - Java 9: clean and modern API

Multi-Resolution image:
  - encapsulates a set of images with different resolutions and allows to query it with a desired height and width

Stack Walking:
  - StackWalker.getInstance(options).walk(Stream<StackFrame> frame -> ...);
  - you can walk up on the stack w/o creating a StackTraceElement[]
  - Stream fetches the frame on demand (optimized)
  - 'options' optimizes more (retain class references into frame only when needed)
  - you CAN NOT access Objects through the call stack upwards, only Class

System.getLogger:
  - a new facade in the JDK9 to get logger
  - JDK logging can be redirected
  - logging defined via Service Loader API (which is also changed in JPMS)
  - checking command line options at the start
  - reserved stackareas
    - annotation @ReservedStackAccess says that do some locking here that would not be good left
      locked because of out of stack error
  - compact strings

Reactive Streams
  - mainly new interfaces in the JDK
    - Publisher
    - Subscriber
    - Subscription
      - Subscription::request implements push-back
    - SubmissionPublisher is not only interface, this is a simple implementation

Collection Factory Methods
  - List.of(...)
  - Set.of(...) there are versions with arguments from 1 to 10 and then varargs (JVM optimization)

  - Map.of(k1, v1, k2, v2, ..., k10, v10) key and value are not necessarily from the same type -> cannot use varargs
  - Map.ofEntries(...)
  - Map.entry(k, v)

  - these create immutable collections

Native Desktop Integration
  - API for desktop integration e.g.:
    - an application can ask attention (blinking, jumping, etc.)
    - an application menu added to the task-bar icon context menu
    - taskbar icon change from application
    - taskbar entries can show progress bar and status
  - Query if Taskbar::isSupported the individual functionalities

Deserialization Filter
  - Serialization is a security risk
  - Deserialization filter is process wide
  - can decide based on
    - Class
    - sizes of arrays being created
    - Stream metrics: length, stream depth and number of references

Networking
  - HTTP/2 (JEP 110, introduction by Steffen Jacobs)
  - Datagram Transport Layer Security (DTLS, JEP 219)
  - TLS Application-Layer Protocol Negotiation Extension (TLS ALPN, JEP 244)
  - OCSP Stapling for TLS (JEP 244) Layer Security

XML
  - JEP 268 suggest to develop a standard XML Catalog API that supports the OASIS XML Catalogs standard
  - OASIS Standard V1.1, 7 October 2005
  - applications should not use internal API and
  - should use the javax.xml.catalog

Extension to existing APIs
  - Optional, Stream and Collectors got new methods
  - many new Stream returning methods in many packages, like Scanner::tokens, Scanner::findAll
  - DateTime API from Java 8 is extended, Duration is also extended
  - Regex Matcher is extended with
    - String replaceAll(Function<MatchResult, String> replacer)
  - Atomic... classes are extended to be used together with VarHandles
  - Math and StrictMath got new methods
  - Arrays comparison is extended with
    - static int compare(a[], aFrom, aTill, b[], bFrom, bTill)
      - arrays can be primitive, T[] and there can be a comparator
      - return value gives the index where comparison fails
  - Objects -> requireNonNull (J8) and now requireNonNullElse and requireNonNullElseGet


Low level APIs
==============

  - VarHandles to access variables more effective in multiple thread
  - Enhanced method handles
  - Dynalink using invokedynamic
  - Nashorn Parser API (if you want to play around with the JavaScript parse tree in Java)
  - SpinWait hint calling Thread::onSpinWait


Deprecations
============

  - @Deprecated
    @Deprecated(since="version", forRemoval=true)
  - since=9 for things deprecated in Java 9 and 1.x for something deprecated sooner
  - Applet API
  - Corba
  - new Integer(5) --> use valueOf(5)
  - Observer and Observable
  - SHA-1 certificates in Jar signing

  - '_' can not be variable name any more (variable name cannot start with underscore)
  - some GC command line options
  - hprof is not there anymore (don't weep: JVisuamVM has it all)
  - jhat is also gone


Miniscules
==========

  - Unicode reading properties files
  - TIFF is supported
  - SHA-3 in MessageDigest API
  - multi-release JAR
  - compile for older version, option -release (sets also the JDK version to compile against, often forgot)
  - JVMI interface to support experimental JIT in Java
  - ahead of time compilation to speed up start
  - JavaDoc generates HTML5 and a small search JavaScript


References
==========

  - https://blog.codefx.org/java/dev/ultimate-guide-java-9/
