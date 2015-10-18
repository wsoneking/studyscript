package cc.megamind.learning;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = {3,4,2,7,9,5,1,6,10,8};
		System.out.println(Arrays.toString(arr));
		quicksort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quicksort(int[] arr, int left, int right) {
		int mid = (left+right)/2;
		int pivot = arr[mid];
		int i = left;
		int j = right;
		while(i<=j) {
			while(arr[i] < pivot) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}
			if(i<=j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--; 
			}
			
		}
		if(i<right) {
			quicksort(arr,i,right);
		}
		if(j>left) {
			quicksort(arr,left,j);
		}
	}

}
