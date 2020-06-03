package com.sdu.letcode;
/**
 * letcode第二题标准答案
 * @author qizhou
 *	2019年9月3日17:14:40
 */
public class Q2a {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(0);
		int carry = 0;
		ListNode temp = l3;
		ListNode p = l1;
		ListNode q = l2;
		while(p!= null || q!= null||carry > 0) {
			int x = (p != null)? p.val : 0;
			int y = (q != null)? q.val : 0;
			int sum = x + y + carry;
			carry = sum/10;
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
			if (p!=null) 	p = p.next;			
			if (q!=null) 	q = q.next;
			
		}		
        return l3.next;
    }
}
