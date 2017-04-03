package com.riccardofinazzi.methodinheritancetest_3.pkgB;

import com.riccardofinazzi.methodinheritancetest_3.pkgA.*;

public class SubclassThatWantstoOverrideInheritedProtectedMethod extends SuperclassWithProtectedMethod {
	
	@Override
	/* Overriding inherited protected method, giving it a less restrictive access l
	 * evel. */
	public void doIt() {
	}
	
}