package algorithm;

import java.util.Arrays;

public class ShellSort {
	public static void main(String args[]){
		System.out.println(Arrays.toString(shellSort2(new int[]{6,2,1,11,9,3,5,8,4,0,7})));
	}
	
	public static int[] shellSort(int[] input){
		
		System.out.println("Original : " +Arrays.toString(input));
		
		int step = input.length/2;
		
		while(step>0){
			System.out.println("Step:"+step);
			for(int out=step;out<input.length;out++){
				int temp = input[out];
				int inner = out;
				boolean isMove = false;
				while(inner>=step&&input[inner-step]>temp){
					System.out.println("compare : " + temp + " with " + input[inner-step]);
					System.out.println("shift : " + input[inner-step] + " to " + input[inner]);
					input[inner] = input[inner-step];
					inner = inner - step;
					isMove = true;
				}
				if(isMove){
					System.out.println("move : " + temp + " to " + input[inner]);
					input[inner] = temp;
					System.out.println("after move : " +Arrays.toString(input));
				}
			}
			System.out.println("Step:"+step+", result : " +Arrays.toString(input));
			step = step/2;
		}
		
		return input;
	}
	
	  public static int[] shellSort2(int[] array){
		  
		  int step = array.length/2;
		  
		  while(step>0){
			  for(int steppedArrayIndex=step;steppedArrayIndex<array.length;steppedArrayIndex++){
				  int temp = array[steppedArrayIndex];
				  int insertionIndexForSteppedArrayIndex = steppedArrayIndex;
				  while(insertionIndexForSteppedArrayIndex>=step&&array[insertionIndexForSteppedArrayIndex-step]>temp){
					  array[insertionIndexForSteppedArrayIndex] = array[insertionIndexForSteppedArrayIndex-step];
					  insertionIndexForSteppedArrayIndex = insertionIndexForSteppedArrayIndex - step;
				  }
				  array[insertionIndexForSteppedArrayIndex] = temp;
			  }
			  step = step/2;
		  }
		  return array;
	  }
}
