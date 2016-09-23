package com.subrata.hackerrankarticle;

import java.util.Set;
import java.util.TreeSet;

public class Divisors {
	
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		int N = 9;
		for (int i = 1;i < Math.sqrt(N) + 1; i++) {
		    if (N % i == 0) {
		    	set.add(i);
		    	set.add(N/i);
		    }
		}
		//set.stream().forEach(e -> System.out.println(e));
		set.stream().forEach(System.out::println);
	}
	
}
