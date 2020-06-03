package com.letcode.dp;
/**
 * Q343整数拆分
 * 
 * @author 祁舟
 *	2019年10月17日20:12:15
 */
public class Q343 {
	
	public int integerBreak(int n) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 1;
		return help(n,dp);
    }
	
	public int help(int n ,int[] dp) {
		if (dp[n] != 0) {
			return dp[n];
		}else {
			int temp = -1;
			for (int i = 1; i < n ; i++) {				
				temp = Math.max(Math.max(temp, i * help(n-i, dp)), i*(n-i));				
			}
			dp[n] = temp;
			return dp[n];
		}

	}
	public static void main(String[] args) {
		
	}
}
