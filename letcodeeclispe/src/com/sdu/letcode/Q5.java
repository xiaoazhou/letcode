package com.sdu.letcode;
import java.lang.Math;
/**
 * letcode第五题
 * @author qizhou
 * 2019年9月5日19:23:19
 */
public class Q5 {
	 public static String longestPalindrome(String s) {
		 char[] cy = s.toCharArray();
		  //如果输入的是空直接返回
	        if (cy.length == 0) {
					return "";
				}
	      //如果输入的长度是1，那么返回他自己
	        if (cy.length == 1) {
				return s.substring(0,1);
			}
			 int len = 0;//最长回文串长度
			 int[] index = {0,0};//用一个数组来存储字符的下标
			 //
			 for (int i = 0; i < cy.length; i++) {
				int temp = i;	
				int j ;
				//寻找和开头字符相同的字符，再检查这一串是否是回文字符串
				while ( (j=s.indexOf(cy[temp],i+1)) != -1) {
					//此处写的不好，指针定义混乱
					i = temp;
					int temp1 = j;
					//定义两个指针一个在头部，一个在和他相同的字符处，不断内缩检查
					while ( i < temp1 ) {
						if (cy[i] == cy[temp1]) {
							i++;
							temp1--;						
						}else {
							 //当两个指针对应的字符不同时直接跳出
							break;
						};
						//当两个指针相遇时，确定是回文，更新len和数组
						if (i >= temp1) {
							len = Math.max(len, j-temp+1);
							if (len == j-temp+1) {
								index[0] = temp;
								index[1] = j;
							}
						}
						
					
					}
					//还原i，因为之前使用了他当做指针(这样不好)
					i = j;				
				}
				//原来没加，找了好久
				//还原i，理由同上
				i = temp;
			}
		     
			 return s.substring(index[0],index[1]+1);
	    }
	public static void main(String[] args) {
		System.out.println(longestPalindrome("ac"));

	}
}
