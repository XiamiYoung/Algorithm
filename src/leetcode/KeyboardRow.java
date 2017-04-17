package leetcode;
import java.util.ArrayList;
import java.util.List;


public class KeyboardRow {
	public static void main(String argsp[]){
		long start = System.currentTimeMillis();
		String[] ret = new KeyboardRow().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
		for(String s:ret){
			System.out.println(s);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
    public String[] findWords(String[] words) {
			List<String> ret = new ArrayList<String>();
			String[] keyBoradList = {"qwertyuiop","asdfghjkl","zxcvbnm"};
			String temp = "";
			for(String word:words){
				temp = word.toLowerCase();
				if(isWordAllowed(temp,keyBoradList)==0){
					ret.add(word);
				}
			}
			return ret.toArray(new String[0]);
	    }
		
		private int isWordAllowed(String word,String[] keyBoradList){
			if(isWordAllowedInLine(word,keyBoradList[0])==0
					||isWordAllowedInLine(word,keyBoradList[1])==0
					||isWordAllowedInLine(word,keyBoradList[2])==0){
				return 0;
			}
			
			return -1;
		}
		
		private int isWordAllowedInLine(String word,String line){
			line = line.toLowerCase();
			for(char c:word.toCharArray()){
				if(line.indexOf(c)==-1){
					return -1;
				}
			}
			return 0;
		}
}
