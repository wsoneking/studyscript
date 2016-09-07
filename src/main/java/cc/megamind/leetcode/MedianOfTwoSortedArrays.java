package cc.megamind.leetcode;

public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,6,8,9};
		int[] b = {3,5,7,10,11};
		
		System.out.println(findMedianSortedArrays(a,b));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int totalLen = len1 + len2;
		if (totalLen % 2 == 0) { // even
			return (findMedian(nums1, 0, len1 - 1, nums2, 0, len2 - 1, totalLen/2) 
					+ findMedian(nums1, 0, len1 - 1, nums2, 0, len2 - 1, totalLen/2 + 1)) * 0.5;
		} else {  // odd
			return findMedian(nums1, 0, len1 - 1, nums2, 0, len2 - 1, totalLen/2);
		}
	}
	
	public static double findMedian (int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
		return 0;
	}

}
