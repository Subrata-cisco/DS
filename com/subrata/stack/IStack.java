package com.subrata.stack;
/**
 * Stack interface
 * @author Subrata Saha.
 *
 * @param <T>
 */
public interface IStack<T> {
  public void push(T val);
  public T pop();
}
