package com.riccardofinazzi.selftest_2;

class Dog {
	public void bark() { System.out.print("woof "); }
}
	
class Hound extends Dog {
	public void sniff() { System.out.print("sniff "); }
	public void bark() { System.out.print("howl "); }
}
public class DogShow {
	public static void main(String[] args) { new DogShow().go(); }
	void go() {
		new Hound().bark();
		((Dog) new Hound()).bark(); /* This is pointless but legal. I have marked this
		 * file and book's page for a review. From what I can understand, this is the 
		 * anonymous version of this statement:
		 *
		   Dog dog = new Hound();
		 * 
		 * Why? Cross away dog legal identifier
		 * 
		   Dog X = new Hound();
		 *
		 * Cross away assign operator, which is used to link stuff at identifiers
		 *
		   Dog X X new Hound();
		 *
		 * Rewrite
		 *
		   (Dog) new Hound();
		 *
		 * See?
		 */
		
		((Dog) new Hound()).sniff(); // won't compile
		/* To quickly guess which method will be invoked by this ugly piece of code yo
		 * u have to remember that the methods you can invoke on an object are decided
		 * at compile time by the compiler which looks at the type of the reference to
		 * the object. A reference can be anonymous, but it MUST have a type. This obj
		 * ect is has an anonymous reference of type is Dog, so the methods that you w
		 * ill be able to invoke are those defined in class Dog and all other methods 
		 * inherited from the inheritance hierarchy */
	}
}