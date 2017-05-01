package com.riccardofinazzi.loops;

public class Loops { 
	
	int age;
	
	void go() {
	outer:
		while(age <= 21) {
			age++;
			if (age == 16) {
				System.out.println("get your driver's license");
				continue outer;
			} else {
				System.out.println("Another year");
			}
		}
	}
	
	public static void main(String[] args) {
		new Loops().go();
	}
}