package com.array.day0226;

import java.util.Arrays;

/**
 * Q16最接近的三数之和
 * 题目描述：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 来源：力扣（LeetCode）
 * 2020年3月23日18:00:26
 * 本题使用双指针方法求解
 */
public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int num = result;
        if (nums.length < 3)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length-1;
            while (l < r){
                int sum = nums[i] + nums [l] + nums [r];
                System.out.println(sum);
                if (sum > target){
                    if (sum - target < result)
                        num = sum;
                    result = Math.min(sum-target,result);
                   r--;
                }else if (sum < target){

                    if (target - sum < result)
                        num = sum;
                    result = Math.min(result,target-sum);
                    l++;
                }else
                    return target;

            }
        }

        return num;
    }

    public static void main(String[] args) {
        Q16 a = new Q16();
        int[] nums = {-1,0,1,1,55};
        System.out.println(a.threeSumClosest(nums,3));
    }
}
