package algorithm;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String args[]){
		System.out.println(Arrays.toString(selectionSort(new int[]{3,2,1,7,6,5,8,4})));
	}
	
	/**
	 * selectionSort
	 * outer:start from first to last
	 * inner:start from outer to last, find min index, place to first
	 * so each inner loop, min index is found and placed to left
	 * 
	 * O(n²)
	 * 
	 * @param input
	 * @return
	 */
	public static int[] selectionSort(int[] input){
		int size = input.length;
		int minIndex = 0;
		
		for(int i=0;i<size;i++){
			minIndex = i;
			for(int j=i;j<size;j++){
				if(input[j]<input[minIndex]){
					minIndex = j;
				}
			}
			int temp = input[minIndex];
			input[minIndex] = input[i];
			input[i] = temp;

		}
		return input;
	}
	
}
