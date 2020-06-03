package com.array.day0226;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：Q350 两个数组的交集2
 * 题目描述：给定两个数组，编写一个函数来计算它们的交集。
 * 2020年3月16日17:40:48
 *
 */
public class Q350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nummap = new HashMap<>();
        List<Integer> resultarr = new ArrayList<>();

        for (int i: nums1) {
            if (nummap.get(i) != null){
                nummap.put(i,nummap.get(i)+1);
            }else
                nummap.put(i,1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nummap.get(nums2[i]) != null){
                resultarr.add(nums2[i]);
                if (nummap.get(nums2[i]) == 1)
                    nummap.remove(nums2[i]);
                else
                    nummap.put(nums2[i],nummap.get(nums2[i]) - 1);
            }
        }

        Object[] objects = resultarr.toArray();
        int[] result = new int[objects.length];
        for (int i = 0; i < resultarr.size(); i++) {
            result[i] = Integer.parseInt(objects[i].toString());
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
