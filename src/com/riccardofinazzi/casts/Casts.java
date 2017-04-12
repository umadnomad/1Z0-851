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
}