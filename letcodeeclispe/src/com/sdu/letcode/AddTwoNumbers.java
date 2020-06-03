package com.sdu.letcode;

import java.util.Arrays;
/**
 * letcode第二题 这种做法会超长
 * @author qizhou
 *
 */
public class AddTwoNumbers {
	public static ListNode addtwonumbers(ListNode l1, ListNode l2) {
        long sum = 0;
        int i1 = 1;
        int i2 = 1;
        
        while(l1 != null) {
        	sum += (l1.val*i1); 
        	i1 *= 10;
        	l1 = l1.next;
        }
        System.out.println(sum);
        while(l2 != null) {
        	sum += (l2.val*i2); 
        	i2 *= 10 ;
        	l2 = l2.next;
        }
        System.out.println(sum);   
        
        String str= String.valueOf(sum);       
        char[] strc = str.toCharArray();
        System.out.println(Arrays.toString(strc));
        //strc.length就是和的位数
        int[] value = new int[strc.length];
        //System.out.println(strc.length);
        String temp = null;
        for (int i = 0; i < strc.length; i++) {
        	temp = String.valueOf(strc[i]);
 			value[i] = Integer.valueOf(temp);
		}
        ListNode l3 = new ListNode(value[strc.length-1]);
        ListNode answer = l3;
        for (int i = 1; i < value.length; i++) {
			l3.next = new ListNode(value[strc.length-1-i]);
			l3 = l3.next;
		}
        return answer;        
    }
	public static void main(String[] args) {
		ListNode ln1= new ListNode(2);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(3);
		ListNode ln2= new ListNode(5);
		ln2.next = new ListNode(6);
		ln2.next.next = new ListNode(4);
		
		ListNode temp = addtwonumbers(ln1, ln2);
		while(temp!=null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
	}
	
}


class ListNode {
     int val;
     ListNode next;
    ListNode(int x) {
    	val = x; 
    	}
}