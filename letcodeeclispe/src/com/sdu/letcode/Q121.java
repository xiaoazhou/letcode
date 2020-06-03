package com.sdu.letcode;
/**
 * ������Ʊ�����ʱ��
 * Q121
 * @author ����qizhou
 *2019��9��6��15:20:37
 */
public class Q121 {
	public static int maxProfit(int[] prices) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		//�����з����ֵ��Сֵ����Ŷ�Ӧ��index
        int[] min = new int[2];
        int[] max = new int[2];
        int temp = 0;
        min[0] = Integer.MAX_VALUE;
        max[0] = Integer.MIN_VALUE;
        min[1] = 0;
        max[1] = 0;
        int profitmax = 0;
        for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min[0]) {
				min[0] = prices[i];
				min[1] = i;
				max[0] = Integer.MIN_VALUE;
			}
			if(prices[i] >= max[0]) {
				max[0] = prices[i];
				max[1] = i;
				
			}
			if (max[1] > min[1]) {
				temp = max[0] - min[0];
			}
			profitmax = Math.max(profitmax,temp);
		}
        System.out.println(min[1]);
        System.out.println(max[1]);
        
        return profitmax;
    }
	public static void main(String[] args) {
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));
}
}
