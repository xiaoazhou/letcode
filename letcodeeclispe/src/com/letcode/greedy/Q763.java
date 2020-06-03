package com.letcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q763:划分字母区间
 * 
 * @author 祁舟
 * 2019年10月4日19:29:34
 */
public class Q763 {
	 public List<Integer> partitionLabels(String s) {
		 	//定义一个List存放答案
		 	List<Integer> nums = new ArrayList<Integer>();
		 	//如果字符串是空，直接返回0
		 	if (s.length() < 1) {
				nums.add(0);
				return nums;
			}
		 	 //将字符串转成char数组，方便取字符
		 	char [] answer = s.toCharArray();
		 	
		 	//a为一段区间的结束位置
		 	int a = -1;
		 	int temp = a;
		 	//当a没有到最后位置时一直循环
	        while ( a != s.length() - 1 ) {
	        	temp = a;
	        
	        	//找到一段区间的结束位置
	        	a = checkchar(a + 1, s.lastIndexOf(answer[a+1]), s, answer);	
	        	//将长度存入
				nums.add(a - temp);			        	
			}
	        return nums;	        
	        
	    }
	 
	 // 查找一段区间的结束位置
	 int checkchar(int a ,int b,String s,char [] charnums){		 
		 	int index = a;
		 	int temp = 0;
		 	
     		for (int i = a; i < b; i++) {
			if ((temp = s.lastIndexOf(charnums[i])) > index) {
				index = temp;
				//如果现在末尾字符不是启示的那个字符，末尾延伸了 需要更新末尾
				if (temp > b) 
				b = temp;
			}
		}     	
     	return index;
    	
     }
	 
	 public static void main(String[] args) {
		Q763 a = new Q763();
		System.out.println(a.partitionLabels("qiejxqfnqceocmy"));
	}
}
