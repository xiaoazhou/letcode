package com.array.day0226;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Double.POSITIVE_INFINITY;

/**
 * 题目：Q149 直线上最多的点数
 * 题目描述：给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 2020年3月28日16:10:15
 * 由于精度问题 无法通过  变态。。。
 * 使用最大公约数可以做
 */
public class Q149 {
    public int maxPoints(int[][] points) {
        int nums = 1;
        int length = points.length;
        if (length < 1)
            return 0;
        Map<Double,Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int[] num = points[i];
            int same = 0;
            int ans = 1;
            for (int j = 0; j < length; j++) {
                if (i != j){
                    double xielv;
                    if (points[j][0] != num[0])
                        xielv = (double)(points[j][1] - num[1])/(points[j][0] - num[0]);
                    else{
                        if (points[j][1]!=num[1])
                            xielv = POSITIVE_INFINITY;
                        else {
                            same++;
                            continue;
                        }
                    }
                    if (!map.containsKey(xielv))
                        map.put(xielv,2);
                    else map.put(xielv,map.get(xielv)+1);
                    ans = Math.max(ans,map.get(xielv));
                }
            }
            map.clear();
            ans = ans + same;
            nums = Math.max(nums,ans);
        }

        return nums;
    }
}
