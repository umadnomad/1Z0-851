package com.riccardofinazzi.interfaces;

class BroaderException extends Exception {};
class IntermediateException extends BroaderException {};
class SmallerException extends IntermediateException {};

class OtherException extends Exception {};

interface Bounceable {
	
	void bounce() throws IntermediateException;
	//void setBounceFactor(); /* Change method signature to take an int parameter */
	
}

public class Ball implements Bounceable {
	
	/* As you can see as long as our implementing method declares an exception whic
	 * h is a subclass of the exception thrown by the method inherited from the int
	 * erface its all okay */
	public void bounce() throws SmallerException {}
	//public void bounce() throws BroaderException {} /* Won't compile ! */
	
	/* In the book, at page 120, it says this code is supposed to compile but I har
	 * dly believe so as the method is set to take an int parameter that was not de
	 * clared in the interface contract */
	public void setBounceFactor(int bf) {}
	/*
		I was right, probably its a typo:
		
		com/riccardofinazzi/interfaces/Ball.java:10: error: Ball is not abstract and does not override abstract method setBounceFactor() in Bounceable
		public class Ball implements Bounceable {
			   ^
		1 error
	*/
	
}