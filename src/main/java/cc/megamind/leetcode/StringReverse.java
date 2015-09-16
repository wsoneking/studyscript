package cc.megamind.leetcode;

public class StringReverse {
	
	public static void main(String[] args) {
		String a = "abcdefg";
		String b = "abc123456";
		System.out.println(reverse(a));
		System.out.println(reverse(b));
	}
	
	static String reverse (String str) {
		if (str == null) {
			return null;
		} else {
			char[] ch = str.toCharArray();
			String toReturn = "";
			for (int i=ch.length -1; i>=0; i--){
				toReturn += ch[i];
			}
			
			return toReturn;
		}
	}

}
