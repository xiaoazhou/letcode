package com.letcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q763:������ĸ����
 * 
 * @author ����
 * 2019��10��4��19:29:34
 */
public class Q763 {
	 public List<Integer> partitionLabels(String s) {
		 	//����һ��List��Ŵ�
		 	List<Integer> nums = new ArrayList<Integer>();
		 	//����ַ����ǿգ�ֱ�ӷ���0
		 	if (s.length() < 1) {
				nums.add(0);
				return nums;
			}
		 	 //���ַ���ת��char���飬����ȡ�ַ�
		 	char [] answer = s.toCharArray();
		 	
		 	//aΪһ������Ľ���λ��
		 	int a = -1;
		 	int temp = a;
		 	//��aû�е����λ��ʱһֱѭ��
	        while ( a != s.length() - 1 ) {
	        	temp = a;
	        
	        	//�ҵ�һ������Ľ���λ��
	        	a = checkchar(a + 1, s.lastIndexOf(answer[a+1]), s, answer);	
	        	//�����ȴ���
				nums.add(a - temp);			        	
			}
	        return nums;	        
	        
	    }
	 
	 // ����һ������Ľ���λ��
	 int checkchar(int a ,int b,String s,char [] charnums){		 
		 	int index = a;
		 	int temp = 0;
		 	
     		for (int i = a; i < b; i++) {
			if ((temp = s.lastIndexOf(charnums[i])) > index) {
				index = temp;
				//�������ĩβ�ַ�������ʾ���Ǹ��ַ���ĩβ������ ��Ҫ����ĩβ
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
