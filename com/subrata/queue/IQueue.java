package com.subrata.queue;
/**
 * Interface for Queue
 * @author Subrata Saha.
 *
 * @param <T>
 */
public interface IQueue<T> {
	public void enQueue(T val);
	public T deQueue();
}
