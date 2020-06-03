package com.letcode.greedy;

import java.util.Arrays;

/**
 * Q452.�����������ļ���������
 * @author ����
 *	2019��9��25��21:26:19
 */
public class Q452 {
	public static int findMinArrowShots(int[][] points) {
		//����������һ��ʼ��1
		int num = 1;
		if (points.length == 0) {
			return 0;
		}
		if (points.length == 1) {
			return num;
		}
		
		//�����鰴β���������򣬴�С����
		Arrays.sort(points,(int[] a, int[] b) ->{						
			return a[1] == b[1]?(a[0] - b[0]):(a[1] - b[1]);							
	});		
		int bound = points[0][1];
		System.out.println(Arrays.deepToString(points));
		
		for (int i = 1; i < points.length; i++) {
			//���û���ص����䣬����������һ
			if (points[i][0] > points[i-1][1]) {
				num ++;
				//��ʱǰ���Ѿ�������������µı߽�
				bound = points[i][1];
			}else {
				//������ص�����������ص�ʱ��һ�����ұ߽�bound
				if (points[i][0] <= bound) {
					//���С��bound ֤�������غ�
					continue;
				}else {
					//��Ȼ����һ�����ص����� ���������bound֤�����Ƕ��غϣ����ü����֮ǰ�غϵ�
					num ++;
					//�����µı߽�
					bound = points[i][1];
				}
			} 
							
		}
			
		return num;
				
    }
	
	public static void main(String[] args) {
		int[][] a = {{10,16}, {2,8}, {1,6}, {7,12}};
		System.out.println(findMinArrowShots(a));
	}
}


