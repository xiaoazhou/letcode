package com.array.day0226;

import java.util.Arrays;

/**
 * 2020年2月20日15:06:10
 * lecode 27题 移除元素
 * 描述：给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Q27 {
    public int moveElement(int[] nums, int val){
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[k++] = nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        Q27 a = new Q27();
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(a.moveElement(nums,2));
        System.out.println(Arrays.toString(nums));
    }
}
