package algorithm;

/**
 * Binary search is effective on search of an array with ordered elements
 * @author i317603
 *
 */
public class BinarySearch {
	public static void main(String[] args) throws Exception{
		binarySearch(new int[]{1,2,3,4,5,6,7,8,9,10},11);
	}
	
	private static void binarySearch(int[] input,int search) throws Exception{
		if(input == null || input.length==0){
			throw new Exception("Invalid Array");
		}
		int low = 0;
		int up = input.length-1;
		boolean found = false;
		while(!found){
			int curr = (low + up)/2;
			if(input[curr]==search){
				found = true;
				System.out.println("Found at index :" + curr);
			}else if(low>up){
				System.out.println("Can not find");
				return;
			}else{
				if(input[curr]<search){
					low = curr + 1;
				}else{
					up = curr - 1;
				}
			}
		}
	}
}
