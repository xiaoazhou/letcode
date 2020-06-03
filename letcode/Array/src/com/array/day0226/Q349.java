package com.array.day0226;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 题目：letcode Q349 两个数组的交集
 * 描述：给定两个数组，编写一个函数来计算它们的交集
 * 2020年3月16日13:13:02
 */

public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> nums1set = new HashSet<>();
        Set<Integer> resultset = new HashSet<>();//使用Set存储

        for (int i:nums1) {//将数组1全部导入set
            nums1set.add(i);
        }

        for (int j:nums2) {//查找set中知否有数组2中的元素
            if (nums1set.contains(j)){
                resultset.add(j);//如果有 存入结果set
            }
        }
        Object[] objects = resultset.toArray();
        int[] resultarr = new int[objects.length];
        for (int i = 0; i < resultarr.length; i++) {
            resultarr[i] = Integer.parseInt(objects[i].toString());
        }

        return resultarr;
    }

    public static void main(String[] args) {

    }
}
