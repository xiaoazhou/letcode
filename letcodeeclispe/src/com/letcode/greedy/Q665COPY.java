package com.letcode.greedy;

import java.util.Arrays;

/**
 * Q665 非递减数列
 * @author 祁舟
 * 	最优解
 *	2019年10月2日22:08:29
 */
public class Q665COPY {
	public boolean checkPossibility(int[] nums) {
		
		for (int i = 0; i < nums.length -1; i++) {
			if (nums[i] > nums[i + 1]) {
				int t = nums[i+1];
				nums[i+1] = nums [i];
				if (isNotDecrease(nums)) {
					return true;
				}else {
					nums[i+1] = t;
					nums[i] = nums[i+1];
					if (isNotDecrease(nums)) {
						return true;
					}
				}
				return false;
			}
		}
		return true;
    }
	
	public boolean isNotDecrease(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return false;
			}
		}
		return true;
	}
		public static void main(String[] args) {
			int[] a = {2,3,3,2,4};
			Q665COPY b = new Q665COPY();
			System.out.println(b.checkPossibility(a));
		}
}

