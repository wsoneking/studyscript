package cc.megamind.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		System.out.println(generate(5));
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists  = new LinkedList<List<Integer>>();
        if(numRows <= 0) {
            return lists;
        }
        List<Integer> pre = new LinkedList<Integer>();
        pre.add(1);
        lists.add(pre);
//         if(numRows >= 2) {
//             pre = new LinkedList<Integer>();
//             pre.add(1);
//             pre.add(1);
//             lists.add(pre);
//         }
        
        for(int k=2; k<=numRows; k++) {
            List curr = new LinkedList<Integer>();
            curr.add(1);
            for(int i=1; i<k-1; i++) {
                curr.add( pre.get(i-1) + pre.get(i) );
            }
            curr.add(1);
            lists.add(curr);
            pre = curr;
            curr = new LinkedList<Integer>();
        }
        
        return lists;
    }
}
