package com.letcode.dp;
/**
 * Q064最小路径和
 * 
 * @author 祁舟
 *	2019年10月11日17:14:33
 */
public class Q064 {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		if (row == 0) {
			return 0;
		}
		int line = grid[0].length;
		if (line == 0) {
			return 0;
		}
		
        int [][] dp = new int[row][line]; 
        //调用函数
       return help(row-1, line-1, grid, dp);
    }
	
	public int help(int m,int n,int[][] grid,int [][] dp) {
		if (dp[m][n] != 0) {
			return dp[m][n];
		}
		
		if (m == 0) {
			for (int i = 0; i <= n; i++) {
				dp[m][n] += grid[m][i];
			}
			return dp[m][n];
		}
		
		if (n == 0) {
			for (int i = 0; i <= m; i++) {
				dp[m][n] += grid[i][n];
			}
			return dp[m][n];			
		}

		return dp[m][n]=Math.min(help(m-1, n, grid, dp), help(m, n-1, grid, dp))+grid[m][n];
	}
	
	
}
