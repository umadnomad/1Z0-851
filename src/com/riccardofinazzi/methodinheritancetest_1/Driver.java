package com.riccardofinazzi.methodinheritancetest_1;

class Driver {
	
	void doDriverStuff() {
		SportsCar car = new SportsCar(); /* instantiation works because default Sports
		 * Car class is in this very same package */
		car.goFast(); /* compile error, invoking a private method on a reference of de
		 * fault SportsCar class */
		
		Convertible con = new Convertible(); /* instantiation works because default Co
		 * nvertible class is in this very same package */
		con.goFast(); /* compile error, invoking a private method on a reference of de
		 * fault SportsCar class */
	}
}
	