package com.riccardofinazzi.generics;

import java.util.*;

public class TestBadLegacy {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(4);
		myList.add(6);
		Inserter in = new Inserter();
		in.insert(myList); // pass List<Integer> to legacy code
	}
}

class Inserter {
	// method with a non-generic List argument
	void insert(List list) {
		list.add(new Integer(42)); /* adds a boxed integer to the incoming list,
		 * which is a type safe Integer ArrayList. all good so far */
		list.add(new String("42"));/* adds a string object to the incoming list,
		 * which is a type safe Integer ArrayList.
		 * This is NOT ok and at the same time no exception or error is thrown.
		 * You will be aware of the problem at runtime during an iteration if pe
		 * rforming type sensitive operations. */
	}
}