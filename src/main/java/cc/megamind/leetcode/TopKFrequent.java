package cc.megamind.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	list.add(entry);
        }
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> l1, Map.Entry<Integer, Integer> l2) {
                return (l1.getValue() - l2.getValue()) * -1;
            }
        });
        
        List<Integer> toReturn = new ArrayList<Integer>();
        int i=0;
        while(i<k) {
            int key = list.get(i).getKey();
            toReturn.add(key);
            i = i + 1;
        }
        return toReturn;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,3,4,7,5,1,1,2,2,3};
		int k = 5;
		List<Integer> result = topKFrequent(nums, k);
		System.out.println(result);
	}
	
}