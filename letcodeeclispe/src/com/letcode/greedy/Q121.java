package com.letcode.greedy;
/**
 * 买卖股票的最佳时机
 * Q121
 * @author 祁舟qizhou
 *2019年9月6日15:20:37
 */
public class Q121 {
	public static int maxProfit(int[] prices) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		//数组中放最大值最小值并存放对应的index
        int[] min = new int[2];
        int[] max = new int[2];
        int temp = 0;
        min[0] = Integer.MAX_VALUE;
        max[0] = Integer.MIN_VALUE;
        min[1] = 0;
        max[1] = 0;
        //最大收益
        int profitmax = 0;
        for (int i = 0; i < prices.length; i++) {
        	//如果最低点发生了变化，更新，并且重置现在的高峰
			if (prices[i] < min[0]) {
				min[0] = prices[i];
				min[1] = i;
				max[0] = Integer.MIN_VALUE;
			}
			//如果高峰发生了变化，更新高峰
			if(prices[i] >= max[0]) {
				max[0] = prices[i];
				max[1] = i;				
			}
			//如果此时卖出有收益，看看收益是多少
			if (max[1] > min[1]) {
				temp = max[0] - min[0];
			}
			//更新最大收益
			profitmax = Math.max(profitmax,temp);
		}
        
        return profitmax;
    }
	public static void main(String[] args) {
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));
	}
}


