package cc.megamind.leetcode;

public class StringToInteger {
	public static void main(String[] args) {
		String a = "123456";
		String b = "-1233216%";
		String c = "   -56  ";
		String d = "-2147483648";
		System.out.println(Integer.MIN_VALUE);
		System.out.println(myAtoi(b));
		System.out.println(myAtoi(c));
		System.out.println(myAtoi(d));
	}
	
	public static int myAtoi(String str) {
		char[] chs = str.trim().toCharArray();
		long result = 0;
		boolean plus = true;
		int i = 0;
		if(str == null || str.equals("")) {
			return 0;
		}
		if(chs[i] == '+') {
			i ++;
		} else if (chs[i] == '-') {
			plus = false;
			i ++;
		}
		while(i<chs.length && chs[i] <= '9' && chs[i] >= '0'   ) {
			result = result * 10 + chs[i] - '0';
			i ++;
			if (result > Integer.MAX_VALUE){
				break;
			}
		}
		if (plus && result > Integer.MAX_VALUE)  {
			return Integer.MAX_VALUE;
		}
		if (!plus && -result < Integer.MIN_VALUE ) {
			return Integer.MIN_VALUE;
		}
		return plus ? (int)result : (int)-result;
	}

}
