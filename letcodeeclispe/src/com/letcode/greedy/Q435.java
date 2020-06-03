package com.letcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Q435 无重叠区间
 * @author 祁舟
 * 2019年9月11日16:56:34
 */
public class Q435 {
	public static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length <= 1) {
			return 0;
		}
		int nums = 0 ;
		
		//将数组按尾部进行排序，从小到大
		Arrays.sort(intervals,(int[] a, int[] b) ->{						
				return a[1] == b[1]?(a[0] - b[0]):(a[1] - b[1]);							
		});
		int end = intervals[0][1];
	
		for (int i = 1; i < intervals.length; i++) {
			//如果一个区间的起点大于等于前一个的终点，则不重叠 直接跳过
			if (intervals[i][0] >= end) {
				end = intervals[i][1];
				continue;
			}else {				
				nums++;
			}
		}		
		return nums;
		}
	public static void main(String[] args) {
		int[][] intervals = {{0,2},{1,3},{1,3},{2,4},{3,5},{3,5},{4,6}};
		System.out.println(eraseOverlapIntervals(intervals));
	}
	}

