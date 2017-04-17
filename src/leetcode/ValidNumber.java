package leetcode;

public class ValidNumber {
	
	public static void main(String[] args) throws Exception {
		System.out.println(isNumber("0"));
		System.out.println(isNumber("0.1"));
		System.out.println(isNumber("abc"));
		System.out.println(isNumber("1 a"));
		System.out.println(isNumber("2e10"));
		System.out.println(isNumber(null));
		System.out.println(isNumber("959440.94f"));
		long start = System.currentTimeMillis();
		System.out.println(new ValidNumber().isNumber("5-2"));
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	public static boolean isNumber(String s) {
		try{
			Double.parseDouble(s);
			return true;
		}catch(Exception e){
			try{
				Float.parseFloat(s);
				return true;
			}catch(Exception e1){
				return false;
			}
		}
    }
}
