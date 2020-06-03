package com.array.day0226;
/**
 * Q219 存在重复元素2
 * 题目描述：给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 来源：力扣（LeetCode）
 * 2020年3月31日18:02:40
 */

import java.util.HashSet;
import java.util.Set;

public class Q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() == k + 1)
                set.remove(nums[i-k]);
        }
        return false;
    }
}
