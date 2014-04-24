package com.subrata.misc;

	import java.util.concurrent.BlockingQueue;
	import java.util.concurrent.LinkedBlockingQueue;
	
	public class ParrallelProcessing {
	
		String transcript = " Hi buddy how are you ?? i wanted to tranfer the file but this fucking im is not allowing me to tranfer .. ";
		String[] slangText = { "fuck", "bullshit" };
		String[] restrictedText = { "transfer", "meet" };
		String[] interestedText = { "password", "account" };
	
		public static void main(String[] args) {
			// Creating shared object
			BlockingQueue sharedQueue = new LinkedBlockingQueue();
	
			// Creating Producer and Consumer Thread
			Thread prodThread = new Thread(new Producer(sharedQueue));
			Thread consThread = new Thread(new Consumer(sharedQueue));
	
			// Starting producer and Consumer thread
			prodThread.start();
			consThread.start();
	
		}
	
	}
	
	class Producer implements Runnable {
	
		private final BlockingQueue sharedQueue;
	
		public Producer(BlockingQueue sharedQueue) {
			this.sharedQueue = sharedQueue;
		}
	
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("Produced: " + i);
					sharedQueue.put(i);
				} catch (InterruptedException ex) {
	
				}
			}
		}
	}
	
	// Consumer Class in Java
	class Consumer implements Runnable {
	
		private final BlockingQueue sharedQueue;
	
		public Consumer(BlockingQueue sharedQueue) {
			this.sharedQueue = sharedQueue;
		}
	
		public void run() {
			while (true) {
				try {
					System.out.println("Consumed: " + sharedQueue.take());
				} catch (InterruptedException ex) {
	
				}
			}
		}
	}