/**
 * Book's page 252 follow up
 *
 * This is called a boxing conversion. The int value is "boxed" into an Integer, which is an Objec
 * t. It has been available in Java since 1.5.
 * <p>
 * The JLS, Section 5.1.7 (http://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.1.7)
 * lists available boxing conversions:
 * <p>
 * Boxing conversion converts expressions of primitive type to corresponding expressions of re
 * ference type. Specifically, the following nine conversions are called the boxing conversions:
 * <p>
 * From type boolean to type Boolean
 * From type byte to type Byte
 * From type short to type Short
 * From type char to type Character
 * From type int to type Integer
 * From type long to type Long
 * From type float to type Float
 * From type double to type Double
 * From the null type to the null type
 * <p>
 * Additionally, the boxing conversion is allowed during method invocation conversion, which is re
 * ally what's going on here. The value is being converted to another type because the int 0 is be
 * ing passed to a method that expects an Object. The JLS, Section 5.3 (http://docs.oracle.com/jav
 * ase/specs/jls/se7/html/jls-5.html#jls-5.3), lists boxing conversion as one method of method inv
 * ocation conversion:
 * <p>
 * Method invocation contexts allow the use of one of the following:
 * <p>
 * an identity conversion (§5.1.1)
 * a widening primitive conversion (§5.1.2)
 * a widening reference conversion (§5.1.5)
 * a boxing conversion (§5.1.7) optionally followed by widening reference conversion
 * an unboxing conversion (§5.1.8) optionally followed by a widening primitive conversion
 */