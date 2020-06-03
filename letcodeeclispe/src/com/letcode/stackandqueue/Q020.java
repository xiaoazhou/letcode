package com.letcode.stackandqueue;

import java.util.Stack;

/**
 * Q20有效的括号
 * 
 * @author 祁舟
 *	2019年10月9日20:03:18
 */

public class Q020 {
	 public boolean isValid(String s) {
		 //用一个栈来存放各种左括号
	        Stack<Character> stack = new Stack<Character>();
	        //将字符串转换为字符数组
	        char [] arr = s.toCharArray();
	        for (char c : arr) {
	        	//如果现在栈中为空
				if (stack.size() == 0) {
					//直接压栈
					stack.push(c);
				}//如果现在不为空，判断是否顺序成对，是的话出栈
				else if(isdouble(stack.peek(), c)){
					stack.pop();
				}//不成对，直接压栈
				else {
					stack.push(c);
				}			
			}
	        //如果栈空，证明全部匹配
	        return stack.size() == 0;
	    }
	 
	 //判断是否顺序匹配
	 public boolean isdouble(char a, char b) {
		 return (a == '('&& b == ')')||(a == '{'&& b == '}')||(a == '['&& b == ']');
	 }
	 
	 public static void main(String[] args) {
		Q020 a = new Q020();
		System.out.println(a.isValid("()"));
	}
}






