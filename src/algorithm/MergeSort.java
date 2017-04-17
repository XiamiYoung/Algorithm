package algorithm;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {

		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(MergeSort.mergeSort(nums, 0, nums.length-1)));
	}
	
	/**
	 * MergeSort
	 * O(n*lgn)
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public static int[] mergeSort(int[] array,int low, int high){
		int mid = (low + high)/2;
		
		if(low==high){//sub array length is 1, return recursive call
			return array;
		}else{
			mergeSort(array,low, mid);
			mergeSort(array,mid+1, high);
			
			mergeSubArray(array,low,mid,high);
		}
		return array;
	}
	
	public static void mergeSubArray(int[] array,int low,int mid,int high){
		//left start index
		int leftArrayIndex = low;
		//right start index
		int rightArrayIndex = mid + 1;
		
		//create a temp array storing sorted and merged data
		int[] tempArray = new int[high-low+1];
		int tempArrayIndex = 0;
		
		//when any of two sub arrays length not exceeded yet 
		while(leftArrayIndex<=mid&&rightArrayIndex<=high){
			if(array[leftArrayIndex]<array[rightArrayIndex]){
				tempArray[tempArrayIndex++] = array[leftArrayIndex++];
			}else{
				tempArray[tempArrayIndex++] = array[rightArrayIndex++];
			}
		}
		
		//when right sub array length exceed, copy all left to temp array
		while(leftArrayIndex<=mid){
			tempArray[tempArrayIndex++] = array[leftArrayIndex++];
		}
		
		//when left sub array length exceed, copy all right to temp array
		while(rightArrayIndex<=high){
			tempArray[tempArrayIndex++] = array[rightArrayIndex++];
		}
		
		//copy tempArray back to array
		//start from low index
		for(int i=0,k=low;i<tempArray.length;i++,k++){
			array[k] = tempArray[i];
		}
	}
}