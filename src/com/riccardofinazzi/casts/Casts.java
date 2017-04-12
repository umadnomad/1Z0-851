package com.riccardofinazzi.casts;

class TestCasts {
	byte x = 3;
	byte y = 8;
	/*
	byte z = x + z; 	// This
	
						// OR
	
	byte z = (x + z)	// This can't be done here! This is allowed only in methods
		
	byte z += x;		// This can't be done either!
	*/
	
	public static void main(String[] args) {
		new TestCasts().goInstance();
		TestCasts.goStatic();
	}
	
	static void goInstance() {
		byte a = 3;
		byte b = 8;
		//byte c = b + c; // // Won't work, expressions always return an int!
		/* error: incompatible types: possible lossy conversion from int to byte */
		
		//byte c = (byte) (b + c); /* error: variable c might not have been initialized */
		byte c = 14;
		//c = (b + c); // Won't work, expressions always return an int!
		/* error: incompatible types: possible lossy conversion from int to byte */
		
		c = (byte) (b + c); // Works
		c += b;				// Works and is equivalent
	}
	
	static void goStatic() {
		byte a = 3;
		byte b = 8;
		//byte c = b + c; // // Won't work, expressions always return an int!
		/* error: incompatible types: possible lossy conversion from int to byte */
		
		//byte c = (byte) (b + c); /* error: variable c might not have been initialized */
		byte c = 14;
		//c = (b + c); // Won't work, expressions always return an int!
		/* error: incompatible types: possible lossy conversion from int to byte */
		
		c = (byte) (b + c); // Works
		c += b;				// Works and is equivalent
	}
	
	/* I am want to add this whole book's example and note, available at page 207:
	 * 
	 *	public class TimeTravel {
	 *		public static void main(String[] args) {
	 *		int year = 2050;
	 *		System.out.println("The year is " + year);
	 *		}
	 *	}
	 * 
	 * Local variables, including primitives, always, always, always must be initia
	 * lized _before_ you attempt to use them (though not necessarily on the same l
	 * ine of code).
	 * Java does not give local variables a default value; you must explicitly init
	 * ialize them with a value, as in the preceding example. If you try to use an 
	 * unitialized primitive in your code, you'll get a compiler error:
	 *
	 *	public class TimeTravel {
	 *		public static void main(String[] args) {
	 *		int year;
	 *		System.out.println("The year is " + year); // Compiler error!!
	 *		}
	 *	}
	*/	