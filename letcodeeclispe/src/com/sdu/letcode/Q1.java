package com.sdu.letcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1 {
	public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i]) )
            {	          	
            		return new int[] {map.get(nums[i]),i};				                
            }else {
				map.put(target -nums[i], i);
			}
        }
        throw new IllegalArgumentException("No two sums Solution");
    }
	
	public static void main(String[] args) {
		int[] nums = {3,3};
		Q1 solution = new Q1();
		System.out.println(Arrays.toString(solution.twoSum(nums, 6)));
	}
}
