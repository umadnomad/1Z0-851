// non-compilable pseudocode

/* generic collections example, I am using using ArrayList but could've been any
 * other collection */

public class ArrayList<E> extends AbstractList<E> implements List<E>...and other interfaces.{
/*					   ^
 * that E stands for element and is a parameterized type. you can pass any class
 * as type here. ArrayLists can hold anything but primitives. If you want them t
 * o contain primitives you will be making use of wrapper classes */

// stuff

public add(E e){...}
public add(int index,E element){...}

// some other stuff

public E get(){...}
public E get(int index){...}

// yet other stuff

public static void main(String[]args){
        List<Animal> = new ArrayList<Animal>();
        //   ^                       ^							^
        List<Dog>    = new ArrayList<Dog>();
        //   ^                       ^
        /* What you put within the angle brackets on the right side of ArrayList
	 * will instantly replace all the occurrences of E within the class body
	 * as if the whole class was written that way to begin with; Then, throu
	 * h the 'new' keyword, you instantiate an object out of it. This can be 
	 * redone unlimited times, thus meaning you can have unlimited versions 
	 * of your collection, each one capable of dealing with a different type
	 * of data. */
        }
}

/* Q: So suppose I have a method doSomething(List<Animal> animals). By all the r
 * ules of inheritance and polymorphism, I would assume that a List<Dog> is a Li
 * st<Animal> and a List<Cat> is a List<Animal> */

/* Short Answer: From Effective Java by Joshua Bloch:
 * Arrays are covariant. Generics are invariant.
 *
 * Covariant simply means if X is subtype of Y then X[] will also be sub type
 * of Y[]. Arrays are covariant As string is subtype of Object, So
 *     String[] is subtype of Object[]
 *
 * Invariant simply means irrespective of X being subtype of Y or not ,
 *     List<X> will not be subType of List<Y> */

 /* Long Answer: */
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

class GenericsAndPolymorphism {
    void doSomething(Animal[] animals) {
        Cat cat = new Cat();
        animals[0] = cat; /* OK unless you pass this method a Dog[] array */
    }

    void doSomethingL(List<Animal> animals) {
        Cat cat = new Cat();
        animals.add(cat); /* perfectly fine. all the collection object's methods
	 * have been customized to work on the parameterized type used to create
	 * it, which is Animal. so if you could read the add() method in this cu
	 * stom generified collection, it would have been: add(Animal a).
	 * A Cat is-a Animal, so it works. */

	/* What would happen if you were allowed to polymorphically pass a List<
	 * Dog> to this method the same way you could pass a Dog[] array in a me
	 * thod designed to accept an Animal[] array as parameter?
	 * What would happen when you try to assign/add the Cat?
	 *
	 * Arrays will stop you as soon as they hit the assignment operator with
	 * an ArrayStoreException unchecked exception;
	 * A collection or generic collection WILL proceed instead, setting you 
	 * up for a MAJOR DISASTER.
	 *
	 * The basis logic for such behavior is that Generics follow a mechanism
	 * of type erasure. So at run time you have no way of identifying the ty
	 * pe of collection unlike arrays where there is no such erasure process.
	 * The point of Generics is to add the compile time type safety, otherwi
	 * se you could just stick with a plain class without generics.
	 * There are times where you need to be more flexible and that is what t
	 * he ? super Class and ? extends Class are for. The former is when you 
	 * need to insert into a type Collection (for example), and the latter i
	 * s for when you need to read from it, in a type safe manner. But the o
	 * nly way to do both at the same time is to have a specific type.
	 *
	 * Early versions of Java and C# did not include generics
	 * (a.k.a. parametric polymorphism).
	 * In such a setting, making arrays invariant rules out useful polymorph
	 * ic programs. For example, consider writing a function to shuffle an a
	 * rray, or a function that tests two arrays for equality using the Obje
	 * ct.equals method on the elements. The implementation does not depend 
	 * on the exact type of element stored in the array, so it should be pos
	 * sible to write a single function that works on all types of arrays.
	 *
	 * Arguably, array covariance nowadays is a language design bug.
	 * Note that due to type erasure, the same behaviour is technically not 
	 * possible for generic collection.
	 *
	 * So while a list of dogs is-a list of animals in English,
	 * a List<Dog> isn't-a List<Animal> in Java.
	 *
	 * Further readings available at:
	 * https://goo.gl/1A4x0y https://goo.gl/fU4KER
	 */
    }
}
