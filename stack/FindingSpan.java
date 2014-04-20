package stack;

import java.util.Stack;

public class FindingSpan {

	public static void printSpan(){
		int[] a = {6,3,4,5,2};
		int[] s = new int[5];
		int j;
		for(int i =0;i<5;i++){
			j=1;
			while(j<=i && a[i]>a[i-j]){
				j++;
			}
			s[i]=j;
		}
		for(int i =0;i<5;i++){
			System.out.println(s[i]);
		}
		
	}
	
	public static void printSpanUsingStack(){
		int[] a = {6,3,4,5,2};
		int[] s = new int[5];
		int p;
		Stack<Integer> d = new Stack<Integer>();
		for(int i =0;i<5;i++){
			while(!d.isEmpty()){
				if(a[i] > a[d.peek()]){
					d.pop();
				}
			}
			
			if(d.isEmpty()){
				p = -1;
			}else{
				p = d.peek();
			}
			
			s[i] = i- p;
			d.push(i);
		}
		
		for(int i =0;i<5;i++){
			System.out.println(s[i]);
		}
	}
	
	public static void main(String[] args) {
		//printSpan();
		printSpanUsingStack();
	}
}
