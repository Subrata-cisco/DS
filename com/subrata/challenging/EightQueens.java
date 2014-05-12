package com.subrata.challenging;

import java.util.ArrayList;

public class EightQueens {

	static int GRID_SIZE = 3;
	
	public static void main(String[] args) {
		Integer[][] array = new Integer[GRID_SIZE][GRID_SIZE];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		int m = 0;
		for(int i = 0;i<GRID_SIZE;i++){
			for(int j = 0;j<GRID_SIZE;j++){
				m++;
				array[i][j] = m;
			}
		}
		
		//print(array);
		
		
		placeME(array);
		
		
		//print(results);
		
		/*ArrayList list = new ArrayList();
		for(int i = 0;i<GRID_SIZE;i++){
			Integer[] columns = new Integer[GRID_SIZE];
			for(int j=0;j<GRID_SIZE;j++){
				columns[j]=array[j][i]; 
			}
			placeQueens(i,columns,results);
			//placeQueens(1,array[1],results);
			//placeQueens(2,array[2],results);
		}*/
		
		
		
		
		
	}
	
	static void placeME(Integer[][] array){
		for(int i = 0;i<GRID_SIZE;i++){
			Integer[] columns = new Integer[GRID_SIZE];
			for(int j=0;j<GRID_SIZE;j++){
				columns[j]=array[j][i]; 
			}
		}
	}
	
	static void print(ArrayList<Integer[]> results){
		for(Integer[] array : results){
			for(Integer p : array){
				System.out.println("*************** Subrata results :"+p);
			}
		}
	}
	
	static void print(Integer[][] array){
		for (int col = 0; col < GRID_SIZE; col++) {
			for(int k=0 ;k<array.length; k++){
				System.out.println("*************** Subrata array ["+col+","+k+"]"+array[col][k]);
			}
		}
	}

	static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) {
			 results.add(columns);
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
					if (checkValidity(columns, row, col)) {
							int t = columns[row];
						columns[row] = 999;/*col*/;
					   System.out.println("*************** Subrata row::" + row
							+ " col::" + col + " prev columns[" + row + "] ::"
							+ t + " aftre columns[" + row + "] ::"
							+ columns[row]);

						placeQueens(row + 1, columns, results);
					}
			}
		}
	}

	static boolean checkValidity(Integer[] columns, int row1, int column1) {
		System.out.println("*************** Subrata validity check row1 ::"+row1);
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			if (column1 == column2) {
				return false;
			}
			int columnDistance = Math.abs(column2 - column1);
			int rowDistance = row1 - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}
}
