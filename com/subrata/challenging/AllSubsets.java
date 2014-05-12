package com.subrata.challenging;

import java.util.ArrayList;

/**
 * 
 * What it is : Printing all the subset of the given list. 
 * Fundamental : Take each the number and insert the sub sequent number on each side of the resulted number list. 
 *
 * @author Subrata Saha (saha.subrata@gmail.com)
 *
 */
public class AllSubsets {
	
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		ArrayList<ArrayList<Integer>> fullList = getEachSet(set,0);
		
		printSets("",fullList);
	}

	/**
	 * Print the values.
	 * @param fullList
	 * @param sb
	 */
	private static void printSets(String text,ArrayList<ArrayList<Integer>> fullList){
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Integer> eachList : fullList) {
			int innerListSize = eachList.size();
			int loop = 0;
			sb.append("(");
			for (int i : eachList) {
				sb.append(i);
				loop++;
				if (loop != innerListSize) {
					sb.append(",");
				}
			}
			sb.append(")");
		}
		System.out.println("*************** Subrata  :: "+text+" "+sb.toString());
	}
	
	/**
	 * Solution having O(2^n) time and space.
	 * @param set
	 * @param index
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> getEachSet(ArrayList<Integer> set,int index){
		ArrayList<ArrayList<Integer>> fullSet;
		if(set.size() == index){
			fullSet = new ArrayList<ArrayList<Integer>>();
			fullSet.add(new ArrayList<Integer>());
		}else{
			fullSet = getEachSet(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> nextSubSets = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> subset : fullSet){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				nextSubSets.add(newsubset);
			}
			printSets("nextSubSets ::",nextSubSets);
			fullSet.addAll(nextSubSets);
			
		}
		printSets("fullSet ::",fullSet);
		return fullSet;
	}
	
}
