Java 13 material
================

Text Blocks
-----------

  - preview feature!!!
  - it allows us to create multiline strings
  - multiline strings have to be written inside a pair of triple-double quotes
  - can’t use text blocks to create a single-line string
  - the opening triple-double quotes must be followed by a line terminator

New Methods in String Class for Text Blocks
-------------------------------------------

  - formatted(Object… args): similar to the String format() method; supports formatting with the
    text blocks
  - stripIndent(): removes the incidental white space characters from the beginning and end of
    every line in the text block; used by the text blocks and it preserves the relative indentation
    of the content
  - translateEscapes(): returns a string whose value is this string, with escape sequences
    translated as if in a string literal

Switch Expressions Enhancements
-------------------------------

  - switch expressions were added as a preview feature in Java 12 release
  - it’s almost same in Java 13 except that the “break” has been replaced with “yield” to return a
    value from the case statement

Reimplement the Legacy Socket API
---------------------------------

  - the underlying implementation of the java.net.Socket and java.net.ServerSocket APIs have been
    rewritten
  - the new implementation, NioSocketImpl, is a drop-in replacement for PlainSocketImpl
  - it uses java.util.concurrent locks rather than synchronized methods
  - if you want to use the legacy implementation, use the java option:
    -Djdk.net.usePlainSocketImpl.

Dynamic CDS Archive
-------------------

  - this extends the class-data sharing feature, which was introduced in Java 10
  - now, the creation of CDS archive and using it is much easier:
    -XX:ArchiveClassesAtExit=my_app_cds.jsa -cp my_app.jar
    -XX:SharedArchiveFile=my_app_cds.jsa -cp my_app.jar

ZGC: Uncommit Unused Memory
---------------------------

  - this feature has enhanced ZGC to return unused heap memory to the operating system
  - the Z Garbage Collector was introduced in Java 11
  - it adds a short pause time before the heap memory cleanup
  - but, the unused memory was not being returned to the operating system
  - this was a concern for devices with small memory footprint such as IoT and microchips
  - now, it has been enhanced to return the unused memory to the operating system

FileSystems.newFileSystem() Method
----------------------------------

  - three new methods have been added to the FileSystems class to make it easier to use file system
    providers, which treats the contents of a file as a file system
  - newFileSystem(Path)
  - newFileSystem(Path, Map<String, ?>)
  - newFileSystem(Path, Map<String, ?>, ClassLoader)

DOM and SAX Factories with Namespace Support
--------------------------------------------

  - there are new methods to instantiate DOM and SAX factories with Namespace support
  - newDefaultNSInstance()
  - newNSInstance()
  - newNSInstance(String factoryClassName, ClassLoader classLoader)
