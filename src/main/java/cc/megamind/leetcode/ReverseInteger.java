package cc.megamind.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		int a = 12345;
		int b = -12345;
		System.out.println(reverse(a));
		System.out.println(reverse(b));
		System.out.println(Integer.MAX_VALUE);
	}

	public static int reverse(int xx) {
		long x = xx;
		long absx = x > 0 ? x : (-x);
		long y = 0;
		while(absx > 0) {
			y = y*10 + absx%10;
			absx = absx / 10;
		}
		if(y > Integer.MAX_VALUE) {
			return 0;
		}
		return x>0 ? (int)y : (int)(-y);

	}
}
