package com.subrata.misc;

public class Dimes {

	public static int makeChanges(int ofMoney, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break; 
		case 5:
			next_denom = 1;
			break;
		case 1:
             return 1;
		}

		int ways = 0;
		for (int i = 0; i * denom <= ofMoney; i++) {
			ways += makeChanges(ofMoney - i * denom, next_denom);
		}
		return ways;
	}
	
	public static void main(String[] args) {
		System.out.println(" Total way ::"+makeChanges(100,25));
	}

}
