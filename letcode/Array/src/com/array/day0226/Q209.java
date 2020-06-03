package com.array.day0226;
/*Q209 长度最小的子数组
描述：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
示例: 输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
2020年3月8日16:55:51
* */

public class Q209 {
    public int minSubArrayLen(int s, int[] nums) {
        int low = 0;              //使用滑动窗口
        int high = -1;
        int sum = 0;
        int ans = nums.length + 1; //初始一个最大值
        while(low < nums.length){
           if (sum < s && high + 1 < nums.length){ //如果现有窗口内的和小于目标值则窗口的右侧向右移动1
                sum += nums[++high];
           }else {                                //反之窗口的左侧向右移动1
               sum -= nums[low++];
           }
           if (sum >= s)                          //如果满足条件，找出现在最短的长度
               ans = Math.min(ans,high-low+1);
        }
        if (ans == nums.length + 1){             //如果长度没有变化，则不存在符合条件的连续子数组
            return 0;
        }
        return  ans;
    }

}
