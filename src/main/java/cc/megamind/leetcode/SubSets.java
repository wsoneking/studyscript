package cc.megamind.leetcode;

import java.util.LinkedList;
import java.util.List;

public class SubSets {
	public static void main(String[] args) {
		int[] aa = {1,2,3};
		
		System.out.println(subsets(aa));
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        int k = 0;
        dfs(k, nums, new LinkedList<Integer>(), lists);
        return lists;
    }
    
    
    public static void dfs(int k, int[] nums, List<Integer> list, List<List<Integer>> lists) {
        if(k == nums.length) {
            lists.add(new LinkedList<Integer>(list));
            return;
        }
        
        list.add(nums[k]);
        dfs(k+1, nums, list, lists);
        list.remove(list.size()-1);
        dfs(k+1, nums, list, lists);
    }
}
