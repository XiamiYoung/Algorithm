package leetcode;

public class StringToInteger {
	
	public static void main(String argsp[]) throws Exception{
		long start = System.currentTimeMillis();
//		10.0
//		abc
//		+-
//		0.1
//		10A -> 10
//		+123A13 -> 123
//		+10 -2
		int res = new StringToInteger().myAtoi("   + 10 -2abc");
		int traditionalInt = new StringToInteger().strToInt("11.2d");
		int nativeInt = new StringToInteger().strToInt("123456789");
		System.out.println(res);
		System.out.println(traditionalInt);
		System.out.println(nativeInt);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	public int myAtoi(String str){
		int res = 0;
		StringBuffer sb = new StringBuffer("");
		if(str==null){
			return res;
		}
		
		str=str.trim();
		if(str.equals("")){
			return res;
		}
		
        for(char c:str.toCharArray()){
        	if(c=='+'||c=='-'){ 
        		//if + or - exists already, break
        		if(sb.indexOf("+")!=-1||sb.indexOf("-")!=-1){
        			break;
        		}
        		sb.append(c);
        	}else if(c<'0'||c>'9'){
        		break;
        	}else{
        		sb.append(c);
        	}
        }
        
        String finalStr = sb.toString();
        
        if(finalStr.equals("+")||finalStr.equals("-")||finalStr.equals("")){
        	return res;
        }
        
        try{
        	res = Integer.parseInt(finalStr);
        }catch(Exception e){
        	if(finalStr.startsWith("-")){
        		res = Integer.MIN_VALUE;
        	}else{
        		res = Integer.MAX_VALUE;
        	}
        }
        
        return res;
    }
	
	/**
	 * Java util method
	 * @param str
	 * @return
	 */
	public int strToInt(String str){
		if(str==null||str.trim().equals("")){
			return 0;
		}
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			str = str.toLowerCase();
			if(str.endsWith("f")||str.endsWith("d")){
				str = str.substring(0, str.length()-1);
			}

			try{
				Double d = Double.parseDouble(str);
				Long l = d.longValue();
				if(l>Integer.MAX_VALUE||l<Integer.MIN_VALUE){
					return 0;
				}
				return l.intValue();
			}catch(Exception e1){
				return 0;
			}
		}
	}
	
	/**
	 * native String to Int
	 * @param str
	 * @return
	 */
	public int nativeStringToInt(String str){
		int ret = 0;
		for(char c:str.toCharArray()){
			//0x31 - 0x30 = (int)1 
			ret += ret*10 + (c-'0');
		}
		
		return ret;
	}
}
