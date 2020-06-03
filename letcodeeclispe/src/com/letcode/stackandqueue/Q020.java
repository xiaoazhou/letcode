package com.letcode.stackandqueue;

import java.util.Stack;

/**
 * Q20��Ч������
 * 
 * @author ����
 *	2019��10��9��20:03:18
 */

public class Q020 {
	 public boolean isValid(String s) {
		 //��һ��ջ����Ÿ���������
	        Stack<Character> stack = new Stack<Character>();
	        //���ַ���ת��Ϊ�ַ�����
	        char [] arr = s.toCharArray();
	        for (char c : arr) {
	        	//�������ջ��Ϊ��
				if (stack.size() == 0) {
					//ֱ��ѹջ
					stack.push(c);
				}//������ڲ�Ϊ�գ��ж��Ƿ�˳��ɶԣ��ǵĻ���ջ
				else if(isdouble(stack.peek(), c)){
					stack.pop();
				}//���ɶԣ�ֱ��ѹջ
				else {
					stack.push(c);
				}			
			}
	        //���ջ�գ�֤��ȫ��ƥ��
	        return stack.size() == 0;
	    }
	 
	 //�ж��Ƿ�˳��ƥ��
	 public boolean isdouble(char a, char b) {
		 return (a == '('&& b == ')')||(a == '{'&& b == '}')||(a == '['&& b == ']');
	 }
	 
	 public static void main(String[] args) {
		Q020 a = new Q020();
		System.out.println(a.isValid("()"));
	}
}






