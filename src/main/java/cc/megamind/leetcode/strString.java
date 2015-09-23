package cc.megamind.leetcode;

public class strString {

	public static void main(String[] args) {
		System.out.println(strStr("abcdefg", "fg"));
	}
	
	public static int strStr(String haystack, String needle) {
        if(needle == null && haystack == null) {
            return 0;
        }
        if(needle.length() == 0 ) {
            return 0;
        }
        int i = 0;
        for(;i<haystack.length()-needle.length()+1;i++){
            int j = 0;
            int k = i;
            while(k < haystack.length() && j<needle.length() && haystack.charAt(k) == needle.charAt(j) ){
                j++;
                k++;
                if(j == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}
