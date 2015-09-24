package cc.megamind.leetcode;

public class FindMedianSortedArrays {
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4, 5, 8, 20, 55, 80};
		double result = findMedianSortedArrays(nums1, nums2);
		System.out.println("result is : " + result);
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		if(len1 == 0 && len2 == 0) {
			return 0;
		} else if (len1 == 0) {
			if(len2%2 != 0){
				return nums2[len2/2];
			} else {
				return (nums2[len2/2] + nums2[(len2+1)/2])*0.5;
			}
		} else if (len2 == 0) {
			if(len1%2 != 0){
				return nums1[len1/2];
			} else {
				return (nums1[len1/2] + nums1[(len1+1)/2])*0.5;
			}
		}
		
		int[] index = findMedian(nums1, nums2, 0, len1-1, 0, len2-1);
		int small = Math.max(nums1[index[0]], nums2[index[2]]);
		int big = Math.min(nums1[index[1]], nums2[index[3]]);

		return (small + big) *0.5;
	}

	private static int[] findMedian(int[] nums1, int[] nums2, int start1, int end1,
			int start2, int end2) {
		int[] index = {start1, end1, start2, end2};
		if(end1-start1 < 2 && end2-start2 < 2 ) {
			return index;
		} else if (end1-start1 < 2) {
			if ((nums1[(start1+end1)/2]) > nums2[(start2+end2)/2]) {
				return findMedian(nums1,nums2,start1,end1,(start2+end2)/2,end2);
			} else {
				return findMedian(nums1,nums2,start1,end1,start2,(start2+end2)/2);
			}
		} else if (end2-start2 < 2) {
			if ((nums1[(start1+end1)/2]) > nums2[(start2+end2)/2]) {
				return findMedian(nums1,nums2,start1,(start1+end1)/2,start2,end2);
			} else {
				return findMedian(nums1,nums2,(start1+end1)/2,end1,start2,(start2+end2)/2);
			}
		} else {
			if ((nums1[(start1+end1)/2]) > nums2[(start2+end2)/2]) {
				return findMedian(nums1,nums2,start1,(start1+end1)/2,(start2+end2)/2,end2);
			} else {
				return findMedian(nums1,nums2,(start1+end1)/2,end1,start2,(start2+end2)/2);
			}
		}
		
	}
	
	

}
