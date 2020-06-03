package com.array.day0226;

import java.util.Arrays;

/**
 * 2020年2月20日15:19:24
 * 题目 letcode 26 删除排序数组中的重复项
 * 题目描述 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Q26 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
           if (nums[i] != nums[i-1]){
               nums[count++] = nums[i];
           }
        }
        return count;
    }

    public static void main(String[] args) {
      Q26 a = new Q26();
      int[] nums = {0,0,1,1,1,2,2,3,3,4};
      System.out.println(a.removeDuplicates(nums));
      System.out.println(Arrays.toString(nums));
    }
}
