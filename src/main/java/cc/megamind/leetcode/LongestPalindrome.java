package cc.megamind.leetcode;

public class LongestPalindrome {
	public static void main(String[] args) {
		String str = "abcddffeabdeedbaehekf";
		System.out.println(str.substring(1, 2));
		System.out.println(longestPalindrome(str)); 
		
	}

	private static String longestPalindrome(String str) {
		if (str == null) {
			return null;
		} else if (str.length() == 1) {
			return str;
		}
		String subStr = "";
		for(int i=0; i<str.length(); i++) {
			String st = getSubstringCenteredBy(i, i, str);
			if(st.length() > subStr.length()){
				subStr = st;
			}
			String st2 = getSubstringCenteredBy(i, i+1, str);
			if(st2.length() > subStr.length()){
				subStr = st2;
			}
		}
		return subStr;
	}

	private static String getSubstringCenteredBy(int i, int j, String str) {
		while(i>=0 && j<str.length() && str.charAt(i) == str.charAt(j)){
			i --;
			j ++;
		}
		return str.substring(i+1, j);
	}

}
