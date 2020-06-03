package com.letcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Q406：根据身高重建队列
 * @author 祁舟
 * 2019年9月11日14:11:26
 * 思路错误
 */
public class Q406 {
	public static int[][] reconstructQueue(int[][] people) {
	       	if (0 == people.length || people[0].length < 2) {
				return new int[0][0];
			}
			LinkedList<int[]> ls = new LinkedList<int[]>();	
			LinkedList<int[]> ls1 = new LinkedList<int[]>();	
			for (int i = 0; i < people.length; i++) {
				ls.add(people[i]);
			}
			//将身高按降序排列 位数按升序排列
			//这种方法值得学习
	        ls.sort(new Comparator<int[]>() {
	            public int compare(int[] o1, int[] o2) {
	            	 return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
	            }
	        });
	        //再按位置插入到指定位置即可
	        for (int[] is : ls) {
				ls1.add(is[1], is);
			}
	        System.out.println(Arrays.deepToString(ls1.toArray(new int[ls1.size()][])));   		
	        return ls1.toArray(new int[ls1.size()][]);
	    }
	public static void main(String[] args) {
		int [][] people =  {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		reconstructQueue(people);
	}
}




