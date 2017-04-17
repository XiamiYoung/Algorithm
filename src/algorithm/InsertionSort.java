package algorithm;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String args[]){
		System.out.println(Arrays.toString(insertionSort(new int[]{3,2,1,7,6,5,8,4})));
	}
	
	/**
	 * O(n²)
	 * Partially ordered on left side, starting from 1.
	 * Loop remaining items, if any of partially ordered item is larger than current item, 
	 * move them towards right,and insert current item at that position.
	 * 
	 * for each loop, at most "i" times compare
	 * 
	 * @param input
	 * @return
	 */
	public static int[] insertionSort(int[] input){
		
		for(int remainingRightIndex=1;remainingRightIndex<input.length;remainingRightIndex++){
			int partiallyOrderedLeftIndex=remainingRightIndex;
			int firstItemOfRemainingRight = input[remainingRightIndex];
			while(partiallyOrderedLeftIndex>0&&input[partiallyOrderedLeftIndex-1]>firstItemOfRemainingRight){
				input[partiallyOrderedLeftIndex]=input[partiallyOrderedLeftIndex-1];
				partiallyOrderedLeftIndex--;
			}
			input[partiallyOrderedLeftIndex] = firstItemOfRemainingRight;
		}
		
		
		return input;
	}
}
