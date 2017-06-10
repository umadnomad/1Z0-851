package com.riccardofinazzi.threads;

public class BlockSynchronization extends Thread {

	private StringBuffer sb;

	public BlockSynchronization(StringBuffer sb) {
		this.sb = sb;
	}

	@Override public void run() {
		synchronized(sb) {
			for (int i = 0; i < 100; i++)
				System.out.println(sb);
			sb.setCharAt(0, (char) (sb.charAt(0) + 1) );
		}
	}

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("A");
		BlockSynchronization t1 = new BlockSynchronization(sb);
		BlockSynchronization t2 = new BlockSynchronization(sb);
		BlockSynchronization t3 = new BlockSynchronization(sb);
		t1.start();
		t2.start();
		t3.start();
	}
}
