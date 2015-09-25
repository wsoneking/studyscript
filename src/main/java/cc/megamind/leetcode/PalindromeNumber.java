package cc.megamind.leetcode;

public class PalindromeNumber {
	
	public static void main(String[] args) {
		int a = 12345;
		int b = 123454321;
		System.out.println(isPalindrome(a));
		System.out.println(isPalindrome(b));
	}
	
	public static boolean isPalindrome(int x) {
		if (x < 0) 
			return false;
		
		int div = 1;
		int pt = x / 10;
		while(pt > 0) {
			div *= 10;
			pt = pt / 10;
		}
		
		while (x > 0) {
			int left = x/div;
			int right = x%10;
			if (left != right) {
				return false;
			}
			x = (x - left*div)/10;
			div /= 100;
		}
		return true;
	}

}
