package com.letcode.dp;

import java.util.Vector;

/**
 * Q070ÅÀÂ¥Ìİ
 * 
 * @author ÆîÖÛ
 * 2019Äê10ÔÂ10ÈÕ20:53:04
 */
public class Q070 {
	 public int climbStairs(int n) {
	        int[] dp = new int[n+1];
	        dp[0] = 1;
	        dp[1] = 1;
	        for (int i = 2; i < n+1; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
	        return dp[n];
	    }
	
	
	public static void main(String[] args) {
		Q070 a = new Q070();
		System.out.println(a.climbStairs(151));
	}
}
