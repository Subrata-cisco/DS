package com.subrata.hackerrankarticle;

public class GCD {
	
	public static void main(String[] args) {
          System.out.println(" GCD ::"+gcd(3,5));
	}

	static int gcd(int a, int b) {
		// base case
		if (a == b)
			return a;

		// a is greater
		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}
}
