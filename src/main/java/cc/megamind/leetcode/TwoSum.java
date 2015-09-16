package cc.megamind.leetcode;

import java.util.HashMap;

public class TwoSum {
	
	public static int[] twoSum (int[] nums, int target) {
		int[] indexes = {0,0};
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> (); 
		for (int i=0; i<nums.length; i++){
			if(!hm.containsKey(nums[i])){
				hm.put(target-nums[i], i+1);
			} else {
				indexes[0] = (Integer) hm.get(nums[i]);
				indexes[1] = i+1;
			}
		}
		return indexes;
	}
	
	public static void main (String[] args) {
		int[] numbers = {5,4,1,2,7,11,15};
		int target = 9;
		int[] index = twoSum(numbers, target);
		System.out.println(index[0] + " and " + index[1]);
	}

}
