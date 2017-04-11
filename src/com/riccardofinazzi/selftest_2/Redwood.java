//package com.riccardofinazzi.selftest_2;

class Redwood extends Tree {
	public static void main(String[] args) {
		new Redwood().go();
	}
	void go() {
		go2(new Tree(), new Redwood());
		go2((Redwood) new Tree(), new Redwood());
	}
	void go2(Tree t1, Redwood r1) {
		//Redwood r2 = (Redwood)t1;
		Tree t2 = (Tree)r1;
	}
}

class Tree {}

// further study

class Dog extends Animal {
	public static void main(String[] args) {
		new Dog().go();
	}
	void go() {
		go2(new Animal(), new Dog());
		go2((Dog) new Animal(), new Dog());
	}
	void go2(Animal animal, Dog dog) {
		Dog r2 = (Dog) animal;
		Animal t2 = (Animal) dog;
	}
}

class Animal {}