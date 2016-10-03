package com.subrata.hackerrankarticle;

import java.util.Scanner;
import java.util.Stack;

public class StackAddDelFindMax {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int length = new Integer(in.nextLine()).intValue();

		Stack<Integer> s = new Stack<>();
		Stack<Integer> maxStack = new Stack<>();

		for (int i = 0; i < length; i++) {
			String line = in.nextLine();
			String[] word = line.split("\\s+");
			int firstNo = new Integer(word[0]);

			if (firstNo == 1) {
				int secondNo = new Integer(word[1]);
				System.out.println("added ::"+secondNo);
				s.push(secondNo);

				if (maxStack.size() == 0 || maxStack.size() >0 && secondNo >= maxStack.peek()) {
					System.out.println("Maxi Added:"+secondNo);
					maxStack.push(secondNo);
				}
			} else if (firstNo == 2) {
				int no = s.pop();
				System.out.println("Pooping "+no);
				if (maxStack.size() >0 && (no == maxStack.peek())) {
					System.out.println("Maxi Deleted :"+maxStack.pop());
				}
			} else if (firstNo == 3) {
				System.out.println(maxStack.size() >0 ?maxStack.peek():0);
			}
		}

	}
}
