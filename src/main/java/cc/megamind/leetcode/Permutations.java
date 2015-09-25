package cc.megamind.leetcode;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class Permutations {
	
	public static void main(String[] args) {
		int[] aa = {1,2,3};
		System.out.println(permute(aa));
	}

	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        dfs(result,list,nums);
        return result;
    }
    
    public static void dfs(List<List<Integer>> result, List<Integer> list, int[] nums) {
    	int[] newNums = new int[nums.length];
    	newNums = nums;
        if(newNums.length == 0) {
            result.add(list);
            return;
        }
        for(int i=0; i<newNums.length; i++) {
        	LinkedList<Integer> newList = new LinkedList<Integer>(list);
        	newList.add(newNums[i]);
        	int[] arry = ArrayUtils.removeElement(newNums, newNums[i]);
            dfs(result, newList, arry);
        }
    }
}
