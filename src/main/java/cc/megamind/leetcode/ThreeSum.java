package cc.megamind.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
		
		String str = "abcdeft";
		str.charAt(0);
	}
	
	public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        if(nums.length<3) {
            return null;
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>> ();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-3; i++) {
            ArrayList<Integer> list =  new ArrayList<Integer>();
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    break;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return lists;
    }
}
