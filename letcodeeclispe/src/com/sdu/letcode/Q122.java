package com.sdu.letcode;
/**
 *   ������Ʊ�����ʱ�ڢ�
 * @author ����
 * 2019��9��10��14:33:23
 */
public class Q122 {
	 public static int maxProfit(int[] prices) {
		 int len = prices.length;
		 //���ֻ��һ��ֱ�ӷ���0
		 if (len <= 1) {
			return 0;
		}
		 //flag��־�����Ƿ��Ѿ����У�Ϊ��ʱ��ʾ����
		 boolean flag = false;
		 //������
		 int Profit = 0;
		 //ÿһ������ʱ�ļ۸�
		 int temp = 0;
		 for (int i = 0; i < len; i++) {
			 //���һ��ʱ
				if (i == len-1) {
					//������ڻ����У�����������ʱ�ļ۸�һ��������ʱ��
					if (flag) {
						Profit += prices[i] - temp;
						break;
						//��������У�ʲô������
					}else {
						break;
					}
				}if (flag) {
					//����ʱ�ж������Ƿ�Ϊ�ֲ�����ߵ�
					if (prices[i+1] < prices[i]) {
						Profit += prices[i] - temp;
						//�����󣬱�Ϊ������
						flag = false;
				}
					}else{
						//δ����ʱ�ж������Ƿ�Ϊ�ֲ�����͵�
					if (prices[i] < prices[i+1]) {
						temp = prices[i];
						//������Ϊ����״̬
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
