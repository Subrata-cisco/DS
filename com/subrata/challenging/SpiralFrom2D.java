package com.subrata.challenging;

public class SpiralFrom2D {

	char a[][]= { {'1','2','3'},{'7','6','5','4'},{'8','9','1'},{'2','3'}};
	
	private static final int SAME_DIRECTION = 1;
	private static final int OPPOSITE_DIRECTION = 2;
	int direction = SAME_DIRECTION;
	
	/**
	 * This method has complexity as O(n^2)
	 */
	private void showSpiral(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<a.length;i++){
			if(direction == SAME_DIRECTION){
				for(int start1=0;start1<a[i].length;start1++){
					sb.append(a[i][start1]);
				}
				direction = OPPOSITE_DIRECTION;
			}else{
				for(int start1=a[i].length -1;start1>= 0;start1--){
					sb.append(a[i][start1]);
				}
				direction = SAME_DIRECTION;
			}
		}
		System.out.println("The string is ::"+sb.toString());
	}
	
	/**
	 * Improve the complexity
	 */
	//char a[][]= { {'1','2','3'},{'7','6','5','4'},{'8','9','1'},{'2','3'}};
	private void showSpiral2(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<a.length;i++){
         // int direction = SAME_DIRECTION;
          int nextPointer = i+1;
          int lengthOfcurrentLoop = -1;
          
          lengthOfcurrentLoop = a[i].length;
          int lengthOfnextLoop = -1;
          
          if(i<a.length ){
        	  lengthOfnextLoop = a[i+1].length;
          }
        	  
          
          
		}
	}

	
	public static void main(String[] args) {
		SpiralFrom2D from2d = new SpiralFrom2D();
		from2d.showSpiral();
	}
	
	
}
