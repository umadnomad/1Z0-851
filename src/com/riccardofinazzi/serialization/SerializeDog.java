package com.riccardofinazzi.serialization;

import java.io.*;

public class SerializeDog {
	
	public static void main(String[] args) {
		Collar c = new Collar(3);
		Dog d = new Dog(c, 5);
		
		System.out.println("before: collar size is " + d.getCollar().getCollarSize());
		try {
			FileOutputStream fs = new FileOutputStream("file.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream("file.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (Dog) ois.readObject();
			ois.close();
		}
		//} catch (IOException | ClassNotFoundException ex) {
			/* Multi-catch, together with the possibility to feed a switch a String is po
			* ssible from java 1.7 on. In java 1.6 you need to catch Exceptions 1 by 1 */
		  catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println("after: collar size is " + d.getCollar().getCollarSize());
	}
}

class Dog implements Serializable {
	private Collar collar;
	private int weight;
	public Dog(Collar collar, int weight) {
		this.collar = collar;
		this.weight = weight;
	}
	public Collar getCollar() {
		return collar;
	}
}

class Collar implements Serializable{
	private int collarSize;
	public Collar(int collarSize) {
		this.collarSize = collarSize;
	}
	public int getCollarSize() {
		return collarSize;
	}
}