package com.letcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Q435 ���ص�����
 * @author ����
 * 2019��9��11��16:56:34
 */
public class Q435 {
	public static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length <= 1) {
			return 0;
		}
		int nums = 0 ;
		
		//�����鰴β���������򣬴�С����
		Arrays.sort(intervals,(int[] a, int[] b) ->{						
				return a[1] == b[1]?(a[0] - b[0]):(a[1] - b[1]);							
		});
		int end = intervals[0][1];
	
		for (int i = 1; i < intervals.length; i++) {
			//���һ������������ڵ���ǰһ�����յ㣬���ص� ֱ������
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

