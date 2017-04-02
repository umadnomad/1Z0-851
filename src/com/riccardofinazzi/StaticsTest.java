package com.riccardofinazzi;

class StaticsTest {
	
	/* Book says I can mark static an initialization block: */
	static {
		System.out.println("Hello World");
	}
	/* Works, verified. */

	static int myClassVariable = 0;
	
	int myInstanceVariable = 0;
	String myObjectName;
	
	StaticsTest(String myObjectName) {
		this.myObjectName = myObjectName;
	}
	
	/* I know that class default access level overwrites these setter's public one,
	 * I mark them public anyway to get used to JavaBeans standards */
	public static void setMyClassVariable() {
		myClassVariable++;
		System.out.println("myClassVariable++");
	}
	
	public void setMyInstanceVariable() {
		myInstanceVariable++;
		System.out.println(this.toString() + ": myInstanceVariable++");
	}
	
	public static String getMyClassVariable() {
		return "myClassVariable is " + myClassVariable;
	}
	
	public void getMyInstanceVariable() {
		System.out.println(this.toString() + ": myInstanceVariable is " + myInstanceVariable + " now.");
	}
	
	public static void main(String[] args) {
		StaticsTest wcbt_a = new StaticsTest("wcbt A");
		StaticsTest wcbt_b = new StaticsTest("wcbt B");
		
		System.out.println("Class related stuff.");
		System.out.println(StaticsTest.getMyClassVariable());
		StaticsTest.setMyClassVariable();
		System.out.println(StaticsTest.getMyClassVariable());
		
		System.out.println("Instance related stuff, object A");
		wcbt_a.getMyInstanceVariable();
		wcbt_a.setMyInstanceVariable();
		wcbt_a.getMyInstanceVariable();

		System.out.println("Instance related stuff, object B");
		wcbt_b.getMyInstanceVariable();
		wcbt_b.setMyInstanceVariable();
		wcbt_b.getMyInstanceVariable();
		wcbt_b.setMyInstanceVariable();
		wcbt_b.getMyInstanceVariable();
		System.out.println("Istantiated objects are now accessing their own class (shared between them) myClassVariable variable now:");
		System.out.println(wcbt_a.toString() + ": " + wcbt_a.getMyClassVariable());
		System.out.println(wcbt_b.toString() + ": " + wcbt_b.getMyClassVariable());
		System.out.println("Object B wants to increase his own Class static variable using his Class' static method on it's own reference variable through dot notation:");
		wcbt_b.setMyClassVariable();
		System.out.println("Object A is now accessing myClassVariable now:");
		System.out.println(wcbt_a.toString() + ": " + wcbt_a.getMyClassVariable());
		
		/* Book says I cannot mark static inner variables: */
		for (int i = 0; i < 10; i++) {
			int x;
		}
		for (int i = 0; i < 10; i++) {
			//static int y;
			/*
				I can't:
				
				com/riccardofinazzi/StaticsTest.java:73: error: illegal start of expression
							static int y;
							^
				1 error
			*/
		}
	}
	
	void staticTestsMethod() {
		class MethodInnerClass {
		}
		/* Book says I cannot mark static a method's local inner class: */
		static class MethodInnerStaticClass {
		}
		/*
			I can't:
			
			com/riccardofinazzi/StaticsTest.java:92: error: illegal start of expression
					static class MethodInnerStaticClass {
					^
			1 error
		*/
	}
	
	
	@Override
	public String toString() {
		return myObjectName;
	}
	
	class MyInnerClass {
		
		/* Book says I can mark static inner class costants: */
		static final int MY_INNER_COSTANT = 0;
		/* It works, verified. */
		
		/*  Book says I cannot mark static: Inner class methods and instance variables: */
		static int myInnerClassVariable = 0;
		/*
			Yes, I can't:
			
			com/riccardofinazzi/StaticsTest.java:81: error: Illegal static declaration in inner class StaticsTest.MyInnerClass
					static int myInnerClassVariable = 0;
							   ^
			  modifier 'static' is only allowed in constant variable declarations
			1 error
		*/
	
		/* Initialization blocks within inner class: */
		static {
			System.out.println("Hello World 2");
		}
		/*
			Generates a compilation error aswell:
			
			com/riccardofinazzi/StaticsTest.java:94: error: Illegal static declaration in inner class StaticsTest.MyInnerClass
					static {
					^
			  modifier 'static' is only allowed in constant variable declarations
			1 error
		*/
		
		/* Book says I cannot mark static inner class methods and instance variables: */
		static void Inner_class_method() {
		}
		/*
			Yes, I can't:
			
			com/riccardofinazzi/StaticsTest.java:107: error: Illegal static declaration in inner class StaticsTest.MyInnerClass
					static void Inner_class_method() {
								^
			  modifier 'static' is only allowed in constant variable declarations
			1 error
		*/
	}
	
	/* I can however see that nested classes can have static variables, methods and
	 * initialization block if they are static too; the following code compiles jus
	 * t fine: */
	static class MyInnerStaticClass {
		
		static final int MY_INNER_COSTANT_2 = 0;
		static int myInnerClassVariable = 0;

		static {
			System.out.println("Hello World 2");
		}

		static void Inner_class_method() {
		}
	}
}

/* Book says I cannot mark an outer class static: */
static class MyOuterStaticClass {
}
/* Indeed I can't, verified. */