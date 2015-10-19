package cc.megamind.learning;

public class LongestCommonSubSequence {
	public static void main(String[] args) {
		String a = "abcdefghijklmn";
		String b = "12ac39dieifkn";
		System.out.println(lcs(a,b));
	}
	
	public static String lcs(String a, String b) {
		if(a==null || b==null) {
			return null;
		}
		if(a.length() == 0 || b.length() == 0 ) {
			return "";
		}
		int alen = a.length();
		int blen = b.length();
		
		if(a.charAt(alen -1) == b.charAt(blen -1)) {
			return lcs(a.substring(0,alen-1),b.substring(0,blen-1)) + a.charAt(alen - 1);
		} else  {
			String x = lcs(a, b.substring(0, blen-1));
			String y = lcs(a.substring(0, alen-1), b);
			return (x.length() > y.length()) ? x : y;
		}
	}

}
