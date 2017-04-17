package leetcode;

public class HammingDistance {
	public static void main(String[] args) throws Exception {
		  System.out.println(hammingDistance(111,222));
		  System.out.println(hammingDistance2(111,222));
		  System.out.println(hammingDistance3(111,222));
		 }
	
  public static int hammingDistance(int x, int y) {
      int dis = Integer.bitCount(x^y);
      return dis;
  }
  
  public static int hammingDistance2(int x, int y){
  	String binaryOXR = Integer.toBinaryString(x^y);
  	int count = 0;
  	for(int i=0;i<binaryOXR.length();i++){
  		if(binaryOXR.charAt(i)=='1'){
  			count++;
  		}
  	}
  	return count;
  }
  
  public static int hammingDistance3(int x, int y){
  	int res = x^y;
  	int count = 0;
  	for(int i=0;i<32;i++){
  		if((res&1)==1){
  			count++;
  		}
  		res = res>>1;
  	}
  	
  	return count;
  }
}
