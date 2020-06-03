package com.array.day0226;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：Q447 回旋镖的数量
 * 题目描述：给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
 * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * 来源：力扣（LeetCode）
 * 2020年3月28日14:59:12
 */
public class Q447 {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;//初始可能数
        Map<Double,Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) { //遍历每一个数组中的点
            int[] tempnum = points[i];
            for (int j = 0; j < points.length; j++) {//记录其他所有点到这个点的距离
                if (i != j) {
                    double length =  Math.pow(points[j][0] - tempnum[0], 2) +
                             Math.pow(points[j][1] - tempnum[1], 2);
                    if (!map.containsKey(length))
                        map.put(length, 1);
                    else{
                        int n = map.get(length);
                        ans +=  n * 2;
                        map.put(length, n + 1);
                    }

                }
            }
            map.clear();
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
