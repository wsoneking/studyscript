package cc.megamind.leetcode;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		String str  =  "]";
		System.out.println(isValid(str));
	}

	public static boolean isValid(String s) {
		Stack<Character> stk = new Stack<Character>();
        char[] chs = s.toCharArray();
        for(char ch : chs) {
            switch(ch) {
                case '(':
                case '{':
                case '[':
                    stk.push(ch);
                    break;
                case ')':
                    if(stk.empty() || stk.pop() != '(')
                        return false;
                    break;
                case '}':
                    if(stk.empty() || stk.pop() != '{')
                        return false;
                    break;
                case ']':
                    if(stk.empty() || stk.pop() != '[')
                        return false;
                    break;
                default:
                    return false;
            }
            
        }
        return true;
    }
}
