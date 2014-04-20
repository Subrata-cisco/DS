package com.subrata.linkedlist;

public class Test {

	public static void main(String[] args) {
		  MyThreadLocal myThreadLocal = new MyThreadLocal();
		 // myThreadLocal.
	}
}

 class MyCounter {
	private int count = 0;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}

 class MyThreadLocal extends ThreadLocal<MyCounter> {
	
}