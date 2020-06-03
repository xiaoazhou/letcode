package com.array.day0226;

import java.util.HashSet;
import java.util.Set;

/**
 * Q217 存在重复元素
 * 题目描述：给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 来源：力扣（LeetCode）
 * 2020年3月31日18:04:06
 */
public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
