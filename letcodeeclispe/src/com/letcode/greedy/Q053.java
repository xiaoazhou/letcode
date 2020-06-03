package com.letcode.greedy;
/**
 * Q53
  *  最大子序和
 * @author 祁舟
 * 2019年9月6日13:55:10
 */
public class Q053 {
	 public static int maxSubArray(int[] nums) {
		 //定义一个数组来存放当前这个位置为截至位置且包含自身的最大子序和
		 int [] store  = new int [nums.length];
		 int max = nums[0];
		 
		 for (int i = 0; i < nums.length; i++) {
			 //如果前面的最大子序和大于0 说明有用，加上
			if (i > 0 && store[i-1] > 0) {
				store[i] = nums[i] + store[i-1];
			}else{//如果不大于0，则说明没有用，直接取自己值存放
				store[i] = nums[i];			
			}
			//存放最大值
			if (max < store[i]) {
				max = store[i];
			}
		}
	        return max;
	    }

	 public static void main(String[] args) {
		int[] nums = {-2};
		System.out.println(maxSubArray(nums));
	}
}
