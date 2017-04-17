package algorithm;

import java.util.Arrays;

public class Bubble {
	public static void main(String args[]){
		System.out.println(Arrays.toString(bubbleSort(new int[]{3,2,1,7,6,5,8,4})));
	}
	
	/**
	 * bubbleSort
	 * O(n²)
	 * outer -- backward
	 * inner -- forward, inner<outer because those have been sorted
	 * @param input
	 * @return
	 */
	public static int[] bubbleSort(int[] input){
		int size = input.length;
		int temp = 0;
		for(int i=size-1;i>1;i--){
			for(int j=0;j<i;j++){
				if(input[j]>input[j+1]){
					temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
			}
		}
		return input;
	}
	
}
