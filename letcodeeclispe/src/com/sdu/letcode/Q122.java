package com.sdu.letcode;
/**
 *   买卖股票的最佳时节Ⅱ
 * @author 祁舟
 * 2019年9月10日14:33:23
 */
public class Q122 {
	 public static int maxProfit(int[] prices) {
		 int len = prices.length;
		 //如果只有一天直接返回0
		 if (len <= 1) {
			return 0;
		}
		 //flag标志现在是否已经持有，为真时表示持有
		 boolean flag = false;
		 //总利润
		 int Profit = 0;
		 //每一次买入时的价格
		 int temp = 0;
		 for (int i = 0; i < len; i++) {
			 //最后一天时
				if (i == len-1) {
					//如果现在还持有，则卖掉，此时的价格一定比买入时高
					if (flag) {
						Profit += prices[i] - temp;
						break;
						//如果不持有，什么都不做
					}else {
						break;
					}
				}if (flag) {
					//持有时判断现在是否为局部的最高点
					if (prices[i+1] < prices[i]) {
						Profit += prices[i] - temp;
						//卖出后，变为不持有
						flag = false;
				}
					}else{
						//未持有时判断现在是否为局部的最低点
					if (prices[i] < prices[i+1]) {
						temp = prices[i];
						//买入后变为持有状态
						flag = true;
					}
				
			}
		}
	        return Profit;
	    }

	 public static void main(String[] args) {
		 int[] a =  {1};
		 System.out.println(maxProfit(a));
	}
}
