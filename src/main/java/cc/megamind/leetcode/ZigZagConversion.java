package cc.megamind.leetcode;

public class ZigZagConversion {
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int nRows = 3;
		System.out.println(convert(s,nRows));
	}
	
	public static String convert(String s, int nRow) {
		if(s == null ) {
			return null;
		}
		if(nRow == 1){
			return s;
		}
		char[] chs = s.toCharArray();
		String neostr = "";
		int K = (nRow-1)*2;
		for(int i=0; i<nRow; i++) {
			for(int j=0; j<s.length(); j++) {
				if(j%K == i || j%K == (K-i)){
					neostr = neostr + chs[j];
				}
			}
		}
		return neostr;
	}

}
