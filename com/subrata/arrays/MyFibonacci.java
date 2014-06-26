package com.subrata.arrays;

/**
 * Fibbonacci series implementation.
 * 
 * @author Subrata Saha.
 *
 */
public class MyFibonacci {

	public static void main(String[] args) {
		fibonacciUsingArrayScan();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 15; i++) {
		 int answer = fibonacciUsingRecursion(i);
		 sb.append(answer).append("->");
		}
		System.out.println("****** Subrata -> Recurion result ::"+sb.toString());
	}
	
	private static int fibonacciUsingRecursion(int number){
		if(number == 0){
			return 0;
		}else if (number == 1){
			return 1;
		}else{
			return fibonacciUsingRecursion(number -1) +fibonacciUsingRecursion(number -2);
		}
	}
	
	private static void fibonacciUsingArrayScan(){
		int febCount = 15;
		int[] feb = new int[febCount];
		feb[0] = 0;
		feb[1] = 1;
		
		for (int i = 2; i < febCount; i++) {
			feb[i] = feb[i - 1] + feb[i - 2];
		}

		for (int i = 0; i < febCount; i++) {
			System.out.print(feb[i] + " ");
		}
	}
	
}
