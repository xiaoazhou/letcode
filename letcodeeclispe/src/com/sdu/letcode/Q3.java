package com.sdu.letcode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 第3题
 * @author qizhou
 * 2019年9月4日14:05:17
 * 使用到了滑动窗口的思想
 */
public class Q3 {
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int flag = 0;
        Set<Character> set = new HashSet<Character>();
        char[] substring = s.toCharArray();
        
        //测试输出
        System.out.println(Arrays.toString(substring));
        
        
        //使用滑动窗口解决为最佳解决方案
        for (int i = 0; i < substring.length; i++) {
        	//移除左边的元素，直到没有元素重合
        	while(set.contains(substring[i])) {
				set.remove(substring[flag]);
				flag++;
			}
			set.add(substring[i]);
    		if (set.size() > max) {
				 max = set.size();
    		}
		}
        return max;
    }
	
	public static void main(String[] args) {
		String s = " ";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
