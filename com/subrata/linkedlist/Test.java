package com.subrata.linkedlist;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Test {

	public static void main(String[] args) {
		//HashMap<Integer,String> m = new HashMap<>();
		//Hashtable<Integer,String> m = new Hashtable<>();
		AbstractQueuedSynchronizer r = null;
		LinkedList<Integer> m = new LinkedList<>();
		
		  //MyThreadLocal myThreadLocal = new MyThreadLocal();
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