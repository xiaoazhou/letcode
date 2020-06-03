package com.array.day0226;

import java.util.*;

/**
 * Q15 三数之和
 * 题目描述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 来源：力扣（LeetCode）
 * 2020年3月23日15:32:59
 * 本题与16题类似 15题使用一开始的想法，16题使用学习后的算法
 */
public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultlist = new HashSet<>(); //使用set保存是为了去重
        Arrays.sort(nums);//先将数组排序，简化去重步骤
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)  //如果此时已经大于0 之后所有元素都大于 0 直接跳出
                break;
            if (i > 0 && nums[i]==nums[i-1]) //去重操作
                continue;
            int target = -nums[i];
            twoSum(target,nums,i,resultlist);  //3个数之和变为2个数之和
        }
        return new ArrayList<>(resultlist);
    }

    public void twoSum(int target, int[] nums,int low,Set<List<Integer>> resultlist) {
        Set<Integer> set = new HashSet<>();//使用Q1中Hash求两数之和的办法求解
        for (int i = low + 1; i < nums.length; i++) {
            if (nums[i] > (target - nums[i]))
                break;
            if (set.contains(target - nums[i])){
                List<Integer> list = Arrays.asList(nums[low],target - nums[i],nums[i]);
                resultlist.add(list);
            }else{
                set.add(nums[i]);
            }

        }
    }
}
