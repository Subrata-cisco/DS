package arrays;

/**
 * a. as all the arrays are sorted do a merge sort and check all next element to find duplicate.
 * 
 * a. check the first element of all the arrays and find minimum .
 * b. where ever the minimum is found only in that array increment the pointer and put all the element in separate array.
 * c. check if the min is equal to any of the element in the separate array i.e duplicate found.
 * d. do it iteratively.
 * 
 * @author subratas
 *
 */
public class FindRepetitionWithoutExtraSpace {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int[][] arr1 = { { 8, 12, 13, 16, 17, 22, 24, 29 },
				{ 4, 8, 14, 16, 18, 23 }, { 33, 36, 37, 44, 95, 126 },
				{ 5, 7, 15, 18 } };
		*/
		int[][] arr = { { 2,4,6,8 },
				{ 3,7,9,10 }, { 6,7,10,12 } };
				
		
		findRepetition(arr);
	}

	public static void findRepetition(int[][] arr) {
		int index[] = new int[arr.length];
		int frontNumber[] = new int[arr.length];
		int length[] = new int[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			length[i] = arr[i].length;
		}
		boolean modified = true;
		while (modified) {
			System.out.println("***********************START LOOP***************************");
			modified = false;
			for (int i = 0; i < arr.length; ++i) {
				if (index[i] < length[i]) {
					modified = true;
					frontNumber[i] = arr[i][index[i]];
					System.out.println("So frontNumber[" + i + "]"
							+ frontNumber[i] + " i ::" + i + " index[" + i
							+ "]" + index[i] + " arr[" + i + "][index[" + i
							+ "]] :: " + arr[i][index[i]]);
			
				} else {
					frontNumber[i] = Integer.MAX_VALUE;
					System.out.println("So index is full frontNumber[" + i + "]"
							+ frontNumber[i]);
				}
			}
			
			for(int k :frontNumber ){
				System.out.print(k+"-");
			}
			
			System.out.println();
			
			
			int min = frontNumber[0];
			int minIndex = 0;
			for (int i = 1; i < arr.length; ++i) {
				System.out.println(" min ::"+min+" frontNumber["+i+"] ::"+frontNumber[i]);
				if (frontNumber[i] == min) {
					if (frontNumber[i] != Integer.MAX_VALUE)
						System.out.print("^"+frontNumber[i]+"^");
					index[i]++;
					System.out.println("front number and min is equal so increment index["+i+"] to ::"+index[i]);
				} else if (frontNumber[i] < min) {
					min = frontNumber[i];
					minIndex = i;
					System.out.println("front number < min so assign min to::"+frontNumber[i]+" thus minIndex ::"+minIndex);
				}
			}
			index[minIndex]++;
			System.out.println(" increament index ["+minIndex+"] to "+index[minIndex]);
			System.out.println("***********************END LOOP***************************");
		}
		System.out.println("index ::");
		for(int k : index){
			System.out.print(k+" ");
		}
		System.out.println(" frontNumber");
		for(int k : frontNumber){
			System.out.print(k+" ");
		}
		System.out.println(" length");
		for(int k : length){
			System.out.print(k+" ");
		}
	}
}
