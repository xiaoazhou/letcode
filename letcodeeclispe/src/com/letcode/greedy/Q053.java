package com.letcode.greedy;
/**
 * Q53
  *  ��������
 * @author ����
 * 2019��9��6��13:55:10
 */
public class Q053 {
	 public static int maxSubArray(int[] nums) {
		 //����һ����������ŵ�ǰ���λ��Ϊ����λ���Ұ����������������
		 int [] store  = new int [nums.length];
		 int max = nums[0];
		 
		 for (int i = 0; i < nums.length; i++) {
			 //���ǰ����������ʹ���0 ˵�����ã�����
			if (i > 0 && store[i-1] > 0) {
				store[i] = nums[i] + store[i-1];
			}else{//���������0����˵��û���ã�ֱ��ȡ�Լ�ֵ���
				store[i] = nums[i];			
			}
			//������ֵ
			if (max < store[i]) {
				max = store[i];
			}
		}
	        return max;
	    }

	 public static void main(String[] args) {
		int[] nums = {-2};
		System.out.println(maxSubArray(nums));
	}
}
