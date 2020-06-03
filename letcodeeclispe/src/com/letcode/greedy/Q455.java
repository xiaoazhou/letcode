package com.letcode.greedy;

import java.util.Arrays;

/**
 * Q455:分发饼干
 * @author 祁舟
 * 2019年9月26日22:13:41
 */

public class Q455 {
	public static int findContentChildren(int[] g, int[] s) {
		//g为胃口值数组
		//s为饼干数组
		//将g和s从小到大排序
			Arrays.sort(g);
			Arrays.sort(s);
			// num表示已经满足的小孩数目
			int num = 0;
			//bound表示已经用到的饼干数目
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

