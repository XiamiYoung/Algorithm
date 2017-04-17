package algorithm;

import java.util.Random;

public class CompareSorting {
	
//OUTPUT
	
//	Sorting array length:100000
//	bubbleSort O(n²)
//	bubbleSort total:13288
//	SelectionSort O(n²)
//	SelectionSort total:2858
//	InsertionSort O(n²)
//	InsertionSort total:2858
//	QuickSort O(nlogn)
//	QuickSort total:13
//	ShellSort O(nlogn)
//	ShellSort total:20
//	MergeSort O(nlogn)
//	MergeSort total:21
	
public static void main(String args[]) {
		
		int MAX_SIZE = 100000;
		
		int[] base = new int[MAX_SIZE];
		for(int i=0;i<MAX_SIZE;i++){
			base[i] = new Random().nextInt();
		}
		
		int[] array = base.clone();
		
		System.out.println("Sorting array length:"+MAX_SIZE);
		
		System.out.println("bubbleSort O(n²)");
		long start1 = System.currentTimeMillis();
		Bubble.bubbleSort(array);
		long end1 = System.currentTimeMillis();
		System.out.println("bubbleSort total:"+(end1-start1));
		
		System.out.println("SelectionSort O(n²)");
		int[] array2 = base.clone();
		long start2 = System.currentTimeMillis();
		SelectionSort.selectionSort(array2);
		long end2 = System.currentTimeMillis();
		System.out.println("SelectionSort total:"+(end2-start2));
		
		System.out.println("InsertionSort O(n²)");
		int[] array3 = base.clone();
		long start3 = System.currentTimeMillis();
		InsertionSort.insertionSort(array3);
		long end3 = System.currentTimeMillis();
		System.out.println("InsertionSort total:"+(end3-start3));
		
		System.out.println("QuickSort O(nlogn)");
		int[] array4 = base.clone();
		long start4 = System.currentTimeMillis();
		QuickSort.classicQuickSort(array4, 0, array4.length-1);
		long end4 = System.currentTimeMillis();
		System.out.println("QuickSort total:"+(end4-start4));
		
		System.out.println("ShellSort O(nlogn)");
		int[] array5 = base.clone();
		long start5 = System.currentTimeMillis();
		ShellSort.shellSort2(array5);
		long end5 = System.currentTimeMillis();
		System.out.println("ShellSort total:"+(end5-start5));
		
		System.out.println("MergeSort O(nlogn)");
		int[] array6 = base.clone();
		long start6 = System.currentTimeMillis();
		MergeSort.mergeSort(array6, 0, array6.length-1);
		long end6 = System.currentTimeMillis();
		System.out.println("MergeSort total:"+(end6-start6));
	}
}
