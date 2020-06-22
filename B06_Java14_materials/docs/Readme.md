Java 14 material
================

Switch Expressions (Standard)
-----------------------------

  - Switch Expressions after staying a preview feature in the last two releases (Java 12 and Java
    13) have finally attained permanent status in Java 14
  - it uses yield statements instead of break for returning values from an expression
  - yield isn’t a new keyword in Java, it’s just used in switch expressions

Pattern Matching for instanceof
-------------------------------

  - preview feature!!!
  - an instanceof conditional check is generally followed by a typecasting
  - Java 14, gets rid of this verbosity by making conditional extraction a lot more concise

Helpful NullPointerExceptions
-----------------------------

  - NullPointerExceptions are a nightmare for any developer. Previously, until Java 13, it was
    tricky to debug them. Developers had to fall onto other debugging tools or manually figure the
    variable/method that was null since the stack trace would only show the line number.
  - this feature is not a language feature, it's an enhancement in the runtime environment
  - let's say Blog is null:
    String name = jd.getBlog().getAuthor();

    Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Blog.getAuthor()" because the return value of "Journaldev.getBlog()" is null
    at NullPointerExample.main(NullPointerExample.java:4)

Records (Preview)
-----------------

  - preview feature!!!
  - a record is a data class that stores pure data
  - normally a class in Java would require you to implement equals(), hashCode() , the getters and
    setters methods. While some IDEs support auto-generation of such classes, the code is still
    verbose. With a record you need to simply define a class in the following way:

    record Author (int id, String name, String topic) {
      static int followers;

      public static String followerCount() {
        return "Followers are "+ followers;
      }

      public String description(){
        return "Author "+ name + " writes on "+ topic;
      }

      public Author{
        if (id < 0) {
          throw new IllegalArgumentException( "id must be greater than 0.");
         }
       }
    }

  - the Java compiler will generate a constructor, private final fields, accessors, equals/hashCode
    and toString methods automatically. The auto-generated getter methods of the above class are
    name() and topic()
  - important things to note about Records:
    - a record can neither extend a class nor it can be extended by another class
    - it’s a final class
    - records cannot be abstract
    - records cannot extend any other class and cannot define instance fields inside the body
    - instance fields must be defined in the state description only
    - declared fields are private and final
    - the body of a record allows static fields and methods

Text Blocks (Second Preview)
----------------------------

  - Text Blocks were introduced as a preview feature in Java 13 with the goal to allow easy
    creation of multiline string literals
  - it’s useful in easily creating HTML and JSON or SQL query strings
  - in Java 14, Text Blocks are still in preview with some new additions:
    - backslash for displaying nice-looking multiline string blocks
    - \s is used to consider trailing spaces which are by default ignored by the compiler, it
      preserves all the spaces present before it

Packaging Tool (Incubator)
--------------------------

  - new jpackage tool to package a Java application into a platform-specific package.
  - Linux: deb and rpm
  - macOS: pkg and dmg
  - Windows: msi and exe
    For example, package the JAR file into an exe file on Windows.

NUMA-Aware Memory Allocation for G1
-----------------------------------

  - new NUMA-aware memory allocation mode, improves the G1 performance on large machines
  - add this option to enable it:
    +XX:+UseNUMA 

JFR Event Streaming
-------------------

  - improved the existing JFR to support event streaming, it means now we can stream the JFR events
    in real-time, without the need to dump the recorded events to disk and parse it manually
  - the JDK Flight Recorder (JFR) is a tool for collecting diagnostic and profiling data about a
    running Java application. Normally, we start a recording, stop it, dump the recorded events to
    disk for parsing, it works well for profiling, analysis, or debugging.

Non-Volatile Mapped Byte Buffers
--------------------------------

  - improved FileChannel API to create MappedByteBuffer that access to non-volatile memory (NVM) –
    a memory that can retrieve stored data even after having been power cycled
  - for example, this feature ensures that any changes which might still be in the cache are
    written back to memory
  - only Linux/x64 and Linux/AArch64 OS support this!

ZGC on macOS
------------

  - introduced the Z Garbage Collector (ZGC) on Linux, and now it ports to macOS

ZGC on Windows
--------------

  - introduced the Z Garbage Collector (ZGC) on Linux, and now it ports to Windows version >= 1803

Foreign-Memory Access API (Incubator)
-------------------------------------

  - an incubator module, allow Java API to access foreign memory outside of the Java heap
