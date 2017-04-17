package leetcode;

public class ComlementNumber {
	
	public static void main(String argsp[]){
		long start = System.currentTimeMillis();
		int res = new ComlementNumber().findComplement(1);
		System.out.println(res);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	//int & 1 == 1,整数与1如果等于1，说明末位是1，否则为0
	public int findComplement(int num) {
		StringBuffer sb = new StringBuffer("");
        while(num>0){
        	if((num&1)==1){
        		sb.insert(0, 0);
        	}else{
        		sb.insert(0, 1);
        	}
        	num>>=1;
        }
        return Integer.valueOf(sb.toString(),2);
    }
}
