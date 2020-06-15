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
