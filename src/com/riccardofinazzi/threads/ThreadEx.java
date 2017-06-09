package com.riccardofinazzi.threads;

public class ThreadEx implements Runnable {
	
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx());
		t.start();
	}
	
	@Override public void run() {
		
		for (int i = 0; i < 100; i++) {
			if ((i % 10) == 0) System.out.println("Every 10");
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
}