package com.riccardofinazzi.methodinheritancetest_1;

class Convertible extends SportsCar {
	
	void doThings() {
		SportsCar sc = new SportsCar(); /* instantiation works because the superclass 
		 * is visible */
		sc.goFast(); /* compile error, invoking a private method on a reference of th
		 * e superclass */
	}
	
	void doMore() {
		goFast(); /* compile error, invoking a private method that cannot be inherited
		 * from the superclass */
	}
}