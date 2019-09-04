package com;

public class BinarySearch {
	public static void main(String[] args) {
		int[] a = {1, 5, 7, 8, 9, 11, 18, 19, 20, 25};
		int target = 2;
		System.out.println(findTarget(a, target));
	}
	public static int findTarget(int[] arr, int target) {
		int result = -1;
		int index = arr.length/2;
		if (arr[index] < target && index >= 0) {
			while(arr[index] < target) {
				index = (arr.length+index)/2;
			}
		} else {
			while(arr[index] > target && index <= arr.length) {
				index = index/2;
			}	
		}
		if (arr[index] == target) {
			result = index+1;
		}
		return result;
	}
}
