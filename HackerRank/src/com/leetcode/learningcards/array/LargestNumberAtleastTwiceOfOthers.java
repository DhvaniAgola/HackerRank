package com.leetcode.learningcards.array;

public class LargestNumberAtleastTwiceOfOthers {

	public static void main(String[] args) {
		int[] nums = {8, 1, 2, 4};

		int largestNumber = 0;
		int foundIndex = -1;

		for (int i = 0; i < nums.length; i++) {
//			if(nums[i]>largestNumber){
//				if(largestNumber*2<=nums[i]){
//					found=true;
//					largestNumber=nums[i];
//				}
//			}
			if (Math.max(nums[i], largestNumber) >= Math.min(nums[i], largestNumber) * 2) {
				foundIndex = nums[i] > largestNumber ? i : foundIndex;
			} else
				foundIndex = -1;
			largestNumber = Math.max(nums[i], largestNumber);
		}
		System.out.println(foundIndex);
	}
}
