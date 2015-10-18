package cc.megamind.learning;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {3,4,2,7,9,5,1,6,10,8};
		System.out.println(Arrays.toString(arr));
//		int[] helper = new int[arr.length];
		mergesort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergesort(int[] arr, int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergesort(arr, left, mid);
			mergesort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int[] helper = new int[arr.length];
		
		for(int i=left; i<=right; i++) {
			helper[i] = arr[i];
		}
		
		int k = left;
		int i = left; 
		int j = mid+1;
		while(i<=mid && j<=right) {
			if(helper[i] < helper[j]) {
				arr[k] = helper[i];
				i++;
			} else {
				arr[k] = helper[j];
				j++;
			}
			k++;
		}
		int rest = mid-i;
		for(int p=0; p<=rest; p++) {
			arr[k+p] = helper[i+p];
		}
	}
}
