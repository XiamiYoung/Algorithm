package leetcode;


public class TeemoAttacking {
	
	public static void main(String argsp[]){
		long start = System.currentTimeMillis();
		int duration = new TeemoAttacking().findPoisonedDuration(new int[]{1,3},2);
		System.out.println(duration);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int start = 0;
        int end = 0;
        if(timeSeries==null||timeSeries.length==0){
        	return res;
        }
        for(int time:timeSeries){
        	start = time;
        	if(start<end){
        		res+=duration-(end-start);
        	}else{
        		res+=duration;
        	}
        	end = start + duration;
        }
        
        return res;
    }
}
