package cc.megamind.leetcode;


public class LengthOfLongestSubstring {
	
	public static void main(String[] args) {
		String str = "abcde";
		System.out.println(lengthOfLongestSubstring(str));
	}

	public static int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        int longest = 0;
        for(int i=0; i<chs.length; i++) {
        	boolean[] flag = new boolean[256];
        	int jj = chs.length - 1;
        	for(int j=i; j<chs.length; j++) {
        		if(flag[chs[j]]){
        			jj = j -1;
        			break;
        		} else {
        			flag[chs[j]] = true;
        		}
        	}
        	int length = jj - i +1;
        	longest = length > longest ? length : longest;
        }
        return longest;
		
    }
}
