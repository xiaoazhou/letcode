package com.letcode.greedy;

import java.util.Arrays;

/**
 * Q455:�ַ�����
 * @author ����
 * 2019��9��26��22:13:41
 */

public class Q455 {
	public static int findContentChildren(int[] g, int[] s) {
		//gΪθ��ֵ����
		//sΪ��������
		//��g��s��С��������
			Arrays.sort(g);
			Arrays.sort(s);
			// num��ʾ�Ѿ������С����Ŀ
			int num = 0;
			//bound��ʾ�Ѿ��õ��ı�����Ŀ
			int bound = 0;
			for (int i = 0; i < g.length; i++) {
				if (bound >= s.length) {
					break;
				}
				while(bound < s.length) {
					if (s[bound] >= g[i]) {
						num++;
						bound++;
						break;
					}else {
						bound++;
					}
				}
				
			}
		
	        return num;
	    }
	
	public static void main(String[] args) {
		int[] a = {};
		int[] b = {};
		System.out.println(findContentChildren(a, b));
	}
}

