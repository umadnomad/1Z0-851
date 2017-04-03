package com.riccardofinazzi.methodinheritancetest_3;

import com.riccardofinazzi.methodinheritancetest_3.pkgB.*;

class Random_Class_That_Wants_To_Use_pkgBs_inherited_but_now_public_overridden_method {
	
	public static void main(String[] args) {
		
		SubclassThatWantstoOverrideInheritedProtectedMethod entity;
		entity = new SubclassThatWantstoOverrideInheritedProtectedMethod();
		
		entity.doIt();
		
	}
}