package cc.megamind.leetcode;

public class ShortenString {
	public static void main(String[] args) {
		String str = "aaabbcccdeffffghhhhhhhihhhihh";
		System.out.println(shorten(str));
	}
	
	public static String shorten(String str) {
		if(str==null) {
			return null;
		}
		if(str.length() <= 1) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		int count = 1;
		int i = 1;
		while(i<str.length()) {
			if(str.charAt(i) == str.charAt(i-1)) {
				count ++;
				
			} else {
				sb.append(count);
				sb.append(str.charAt(i-1));
				count = 1;
			}
			i++;
		}
		sb.append(count);
		sb.append(str.charAt(i-1));
		return sb.toString();
	
	}

} 