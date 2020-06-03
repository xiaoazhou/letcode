package com.letcode.dp;
/**
 * Q062不同路径
 * 
 * @author 祁舟
 * 2019年10月17日21:55:11
 */
public class Q062 {
	 public int uniquePaths(int m, int n) {
		 	
	        int[][] dp = new int[m+1][n+1];
	        return help(m,n,dp);
	    }
	 
	 private int help(int m, int n,int[][] dp) {
		if (m == 1|| n == 1) {
			return 1;
		}
		if (dp[m][n] != 0) {
			return dp[m][n];
		}
		dp[m][n] = help(m-1, n, dp) + help(m, n-1, dp);
		return dp[m][n];

	}
}
