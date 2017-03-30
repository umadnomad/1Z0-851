package com.riccardofinazzi.methodinheritancetest_2.somethingElse;

import com.riccardofinazzi.methodinheritancetest_2.certification.OtherClass;

class AccessClass extends OtherClass {
	
	public static void main(String[] args) {
		/* OtherClass oc = new OtherClass(); /* a subclass outside of it's SuperClass 
		 * package inherits sc' protected members; It does not, however, mean the sub
		 * class-outside-the-package can access the member using a reference to an in
		 * stance of the superclass. In other words, protected = inheritance. */
			
		// so...
		
		new AccessClass().testIt();
	}
	
}