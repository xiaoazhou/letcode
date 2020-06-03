package com.letcode.greedy;
/**
 * Q605�ֻ�����
 * @author ����
 * 2019��9��26��22:45:08
 */
public class Q605 {
	 public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		 int num = 0;
		 //���Ҫ�����ֲ��Ϊ0��ֱ�ӷ���true
		 if (n < 1) {
			return true;
		}
		 //����һ�����飬ǰ��0
		 int[] temp = new int[flowerbed.length+2];
		 temp[0] = 0;
		 temp[flowerbed.length+2-1] = 0;
		 System.arraycopy(flowerbed, 0, temp, 1, flowerbed.length);
		 //ÿ��λ�ý����ж�
		 	for (int i = 1; i < temp.length-1; i++) {		
		 		//�����ǰλ��û���ֻ�
				if (temp[i] == 0) {
					//�ж�ǰ��û���ֻ��������û��������һ��
					if ((temp[i-1] == 0) && (temp[i+1] == 0)) {
						//�����Ѿ����µĻ�����Ŀ
						num++;
						temp[i] = 1;
					}
				}
			}
		 	//�ж����µĻ��ǲ�������Ҫ��
		 	if (num >= n) {
				return true;
			}else {
				return false;
			}
	        
	    }
	 
	 public static void main(String[] args) {
		int[] a = {0};
		int n = 1;
		System.out.println(canPlaceFlowers(a, n));
	}
}

