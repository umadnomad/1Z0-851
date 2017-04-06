package com.riccardofinazzi;

import java.lang.reflect.InvocationTargetException;

class Animal {
	static void doStuff() {
		System.out.print("a ");
	}
}
class Dog extends Animal {
	/* Book says this is not an override and indeed it's not: the run-time type is 
	 * not used to determine which static methods are called. Further explanation i
	 * s available below */
	static void doStuff() {
		System.out.print("d "); 
	}

	public static void main(String[] args) {

		Animal[] a = {new Animal(), new Dog(), new Animal()};
		for (int x = 0; x < a.length; x++) {

			a[x].doStuff(); // Original code */

			/* Will print a a a, you cannot override a static method, because unlike inst
			 * ance methods which are dinamically choosen by the JVM at runtime, with sta
			 * tics the method to be executed is decided by the compiler, who will look a
			 * t the type of the reference variable you are invoking the method on and th
			 * en will execute the method declared in the matching class.
			 *
			 * An example which applies to the code in this file:
			 *
			   Animal animal = new Dog();
			   Dog dog;
			   animal = (Dog) animal;
			   animal.doStuff();
			   // Animal class' doStuff() method will run even if the object is a dog
			 * 
			 * To use Dog's doStuff() method, you can't do anything but using a different
			 * reference variable of type Dog, because, remember, you can never change th
			 * e type of a ref var, so animal ref var will forever be of Animal type. 
			 * 
			   Animal animal = new Dog();
			   Dog dog;
			   dog = (Dog) animal;
			   dog.doStuff();
			   // The object creation is exactly the same but now the static method declare
			   // d within Dog class will run. Why? because, again, which static method to 
			   // run is decided at compile time by the compiler (o'rly?), and the compiler
			   // looks for the type of the reference variable.
			*/
		}

		System.out.println("Further testing");

		/* Dog[] b = {new Animal(), new Dog(), new Animal()}; // Compile error! */
		
		/* This happens because a Dog is an Animal, but not every Animal is a Dog.
		 * An example with simpler code is shown below:
		 *
		   Animal animal = new Animal();
		   Dog dog = animal;
		   --> Compile error: incompatible types: Animal cannot be converted to Dog
		 * 
		 * Question: Why subclass object cannot be implicitly converted to superclass
		 * object in Java?
		 * 
		 * Answer: You must think the other way around: The system cannot know whether
		 * Animal supports features of Dog - Animal is just a subset of the features p
		 * rovided by Dog */

		System.out.println("Further testing");

		/* This is an incredibly funny yet clever hack to do a sort of an ovverride o
		 * fa static method!
		 * Credits go to http://stackoverflow.com/users/1517187/patlatus */
		for (int i = 0; i < a.length; i++) {
			try {
				try {
					a[i].getClass().getDeclaredMethod("doStuff").invoke(a[i]);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
	}
}