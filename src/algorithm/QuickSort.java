package algorithm;

import java.util.Random;

/**
 * QuickSort
 * 
 * O(nlgn)
 * @author i317603
 *
 */
public class QuickSort {

	static int CUT_OFF = 10;
	
	public static void main(String args[]) {
		
		int MAX_SIZE = 10000000;
		
		int[] base = new int[MAX_SIZE];
		for(int i=0;i<MAX_SIZE;i++){
			base[i] = new Random().nextInt();
		}
		
		int[] array = base.clone();
		long start1 = System.currentTimeMillis();
		classicQuickSort(array, 0, array.length-1);
		long end1 = System.currentTimeMillis();
		System.out.println("classicQuickSort total:"+(end1-start1));
		
//		System.out.println(Arrays.toString(array));
//		System.out.println(Arrays.toString(classicQuickSort(array, 0, array.length-1)));
		int[] array2 = base.clone();
		long start2 = System.currentTimeMillis();
		medianOfThreeQuickSort(array2, 0, array2.length-1);
		long end2 = System.currentTimeMillis();
		System.out.println("medianOfThreeQuickSort total:"+(end2-start2));
//		System.out.println(Arrays.toString(array2));
//		System.out.println(Arrays.toString(medianOfThreeQuickSort(array2, 0, array2.length-1)));
		int[] array3 = base.clone();
		long start3 = System.currentTimeMillis();
		medianOfThreeWithCutoffQuickSort(array3, 0, array3.length-1);
		long end3 = System.currentTimeMillis();
		System.out.println("medianOfThreeWithCutoffQuickSort total:"+(end3-start3));
//		System.out.println(Arrays.toString(array3));
//		System.out.println(Arrays.toString(medianOfThreeWithCutoffQuickSort(array3, 0, array3.length-1)));
		
		int[] array4 = base.clone();
		long start4 = System.currentTimeMillis();
		classicWithCutoffQuickSort(array4, 0, array4.length-1);
		long end4 = System.currentTimeMillis();
		System.out.println("classicWithCutoffQuickSort total:"+(end4-start4));
	}

	public static int[] classicQuickSort(int[] array, int low, int high) {

		if(low>=high){
			return array;
		}
		
		int pivot = array[high];
		int partitionPoint = partition(array,low,high,pivot);
		
		//partition point has been finalized, recursive from -1 and +1
		classicQuickSort(array,low,partitionPoint-1);
		classicQuickSort(array,partitionPoint+1,high);
		
		return array;
	}
	
	public static int[] classicWithCutoffQuickSort(int[] array, int low, int high) {

		if(low>=high){
			return array;
		}else if(high-low<=CUT_OFF-1){
			InsertionSort.insertionSort(array);
			return array;
		}else{
			int pivot = array[high];
			int partitionPoint = partition(array,low,high,pivot);
			
			//partition point has been finalized, recursive from -1 and +1
			classicQuickSort(array,low,partitionPoint-1);
			classicQuickSort(array,partitionPoint+1,high);
			
			return array;
		}
	}
	
	public static int[] medianOfThreeWithCutoffQuickSort(int[] array, int low, int high){
		if(low>=high){
			return array;
		}else if(high-low<=CUT_OFF-1){
			InsertionSort.insertionSort(array);
			return array;
		}else{
			//find median of low, high and center
			//trying to avoid getting min or max of array to cause worst division
			int pivot = medianOfThreeAndPutPivotToRight(array,low,high);
			int partitionPoint = partition(array,low,high,pivot);
			
			//partition point has been finalized, recursive from -1 and +1
			medianOfThreeQuickSort(array,low,partitionPoint-1);
			medianOfThreeQuickSort(array,partitionPoint+1,high);
			
			return array;
		}
	}
	
	public static int[] medianOfThreeQuickSort(int[] array, int low, int high){
		if(low>=high){
			return array;
		}
		
		//find median of low, high and center
		//trying to avoid getting min or max of array to cause worst division
		int pivot = medianOfThreeAndPutPivotToRight(array,low,high);
		int partitionPoint = partition(array,low,high,pivot);
		
		//partition point has been finalized, recursive from -1 and +1
		medianOfThreeQuickSort(array,low,partitionPoint-1);
		medianOfThreeQuickSort(array,partitionPoint+1,high);
		
		return array;
	}
	
	private static int medianOfThreeAndPutPivotToRight(int[] array, int low, int high){
		int median = (low + high)/2;
		
		//sort these three items
		if(array[low]>array[median]){
			swap(array,median,low);
		}
		
		if(array[median]>array[high]){
			swap(array,median,high);
		}
		
		if(array[low]>array[median]){
			swap(array,median,low);
		}
		
		//after sorting, put pivot to right
		swap(array,median,high);
		
		return array[high];
	}

	private static int partition(int[] array,int low, int high, int pivot) {
		//make left pointer out of first item
		//make right pointer on the pivot -> which should be ignored at this step
		int leftPointer = low - 1;
		int rightPointer = high;
		
		while(true){
			//from left to right, search larger than equal item
			//as pivot is the last item, it is not larger than equal to array[leftPointer], when clause will break
			while(array[++leftPointer]<pivot);
			
			//from right to left, search less than equal item
			while(array[--rightPointer]>pivot&&rightPointer>0);
		
			if(leftPointer>=rightPointer){
				break;
			}else{
				swap(array,leftPointer,rightPointer);
			}
		}
		
		//as pivot is ignored, swap it from right to first item of right sub array
		//leftPointer is pointing to the first item that larger than equal to pivot(breaks when clause)
		//so it's the first item of right sub array
		swap(array,leftPointer,high);
		
		//return leftPointer as partition int
		return leftPointer;
	}
	
	private static void swap(int[] array,int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}

