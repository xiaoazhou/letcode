package com.letcode.greedy;

import java.util.Arrays;

/**
 * Q452.用最少数量的箭引爆气球
 * @author 祁舟
 *	2019年9月25日21:26:19
 */
public class Q452 {
	public static int findMinArrowShots(int[][] points) {
		//箭的数量，一开始是1
		int num = 1;
		if (points.length == 0) {
			return 0;
		}
		if (points.length == 1) {
			return num;
		}
		
		//将数组按尾部进行排序，从小到大
		Arrays.sort(points,(int[] a, int[] b) ->{						
			return a[1] == b[1]?(a[0] - b[0]):(a[1] - b[1]);							
	});		
		int bound = points[0][1];
		System.out.println(Arrays.deepToString(points));
		
		for (int i = 1; i < points.length; i++) {
			//如果没有重叠区间，箭的数量加一
			if (points[i][0] > points[i-1][1]) {
				num ++;
				//此时前面已经被射掉，更新新的边界
				bound = points[i][1];
			}else {
				//如果有重叠区间则记下重叠时第一个的右边界bound
				if (points[i][0] <= bound) {
					//如果小于bound 证明还是重合
					continue;
				}else {
					//虽然与上一个有重叠区间 但如果大于bound证明不是都重合，则用箭射掉之前重合的
					num ++;
					//更新新的边界
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


