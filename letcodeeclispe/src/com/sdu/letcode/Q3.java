package com.sdu.letcode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 * ��3��
 * @author qizhou
 * 2019��9��4��14:05:17
 * ʹ�õ��˻������ڵ�˼��
 */
public class Q3 {
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int flag = 0;
        Set<Character> set = new HashSet<Character>();
        char[] substring = s.toCharArray();
        
        //�������
        System.out.println(Arrays.toString(substring));
        
        
        //ʹ�û������ڽ��Ϊ��ѽ������
        for (int i = 0; i < substring.length; i++) {
        	//�Ƴ���ߵ�Ԫ�أ�ֱ��û��Ԫ���غ�
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
