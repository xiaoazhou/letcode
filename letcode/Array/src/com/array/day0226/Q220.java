package com.array.day0226;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Q220 存在重复元素3
 * 题目描述：给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * 来源：力扣（LeetCode）
 * 2020年3月31日21:05:06
 */
public class Q220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set= new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if ((ceiling != null) && ceiling <= ((long)nums[i] + (long) t))
                return true;
            set.add((long)nums[i]);
            if (set.size() == k + 1)
                set.remove((long)nums[i-k]);
        }
        return false;
    }

}
