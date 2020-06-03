package com.letcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 * @author 祁舟
 *
 */
public class Q120 {
	
	 public int minimumTotal(List<List<Integer>> triangle) {
		 	int row = triangle.size();
	        int [] dp = new int[row];
	        for (int i = 0; i < row; i++) {
				dp[i] = triangle.get(row-1).get(i);
			}
	       
	        for (int level = row - 2;level >= 0; level--) {
				for (int i = 0; i <= level; i++) {
					dp[i] = Math.min(dp[i], dp[i+1]) + triangle.get(level).get(i);
				}
			}
	        return dp[0];
	        
	    }
	
	public static void main(String[] args) {
		
		
	}
}
