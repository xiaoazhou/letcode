package com.array.day0226;

import java.util.HashMap;
import java.util.Map;

/**
 * Q454 四数相加 II
 * 题目描述：给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1
 * 来源：力扣（LeetCode）
 * 2020年3月24日15:34:23
 */
public class Q454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();   //将4个数组分成两组
        for (int i = 0; i < C.length; i++) {//C D两组的所有可能和保存到map中 key为和，value为出现次数
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(C[i] + D[j])){//如果已经在map中 value + 1
                    map.put(C[i] + D[j],map.get(C[i] + D[j])+1);
                }else                             //如果不在map中 value置为1
                    map.put(C[i] + D[j],1);
            }
        }

        for (int i = 0; i < A.length; i++) {//遍历所有 A B 的组合 看看是否有所缺的剩余值在map中
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(-A[i]-B[j])){
                    sum += map.get(-A[i]-B[j]);//如果剩余值在map中 就加上Value 代表有这么多组合和可以为0
                }
            }
        }
        return sum;
    }
}
