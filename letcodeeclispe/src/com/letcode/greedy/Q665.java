package com.letcode.greedy;
/**
 * Q665 �ǵݼ�����
 * @author ����
 * 
 *	2019��10��2��22:08:29
 */
public class Q665 {
	public static boolean checkPossibility(int[] nums) {
		//����Ҫ�ı��Ԫ����Ŀ
		int num = 0;
		//����ǰ������ͷ������Сֵ��β�������ֵ
        int [] temp = new int[nums.length + 2];
        temp[0] = Integer.MIN_VALUE;
        temp[temp.length - 1]  = Integer.MAX_VALUE;
        for (int i = 1; i < temp.length - 1; i++) {
			temp[i] = nums[i-1];
		}
        
        //ѭ��������ÿ��λ��
        for(int i = 1 ;i < temp.length - 1; i++)
        {	
        	//�����ǰ�����ڵ���ǰ���С�ڵ��ں���
           if (temp[i] <= temp[i+1] && temp[i] >= temp[i-1] ) {
        	   //����ǵݼ���ֱ��continue
			continue;
           }else {
        	   //���������
        	   //�жϺ�����ǲ��Ǵ���ǰ��
        	   if (temp[i+1] >= temp[i-1]) {
        		   //����������ǰ��ı����ֵΪС��
        		   temp[i] = temp[i-1];
            	   num++;
            	   //���num����1��ֱ�ӷ���fasle
            	   if (num > 1) {
    				return false;
			} }
        	   //��������С��ǰ���
        	   else {
        		   //�ı�����ֵΪĿǰ��ֵ
				temp[i+1] = temp[i];
				//�ı������������㣬ֱ������
				if (temp[i+1] < temp[i - 1]) {
					return false;
				}
				//�������Ļ���num��Ŀ����
				else {
					//���num����1��ֱ�ӷ���fasle
					num++;
					if (num > 1) {
	    				return false;
				}
			}
        	   
				}
        	   }
           }
        //ִ����ϣ���û��������ֱ�ӷ���true
        return true;
    }
	
		public static void main(String[] args) {
			int[] a = {2,3,3,2,4};
			System.out.println(checkPossibility(a));
		}
}
