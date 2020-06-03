package com.letcode.linklist;

/**
 * Q234  回文链表
 * 题目描述：请判断一个链表是否为回文链表。
 * 2020年5月18日13:28:43
 * @author xiaoazhou
 */

public class Q234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        //half将链表分为两半，secondhead是第二段的头结点
        ListNode half = endOfLinklist(head);
        ListNode secondhead = reverseList(half.next);

        ListNode copy = head;
        ListNode copysecond = secondhead;

        //使用reslut可以在不论什么情况，最后都将链表还原
        boolean result = true;

        //循环比较是否是回文串，发现不相等将result改变不直接返回
        while (result && copysecond != null){
            if (copysecond.val != copy.val)
                result = false ;
            else {
                copysecond = copysecond.next;
                copy = copy.next;
            }
        }

        //无论是不是回文，都在最后将链表还原
        half.next = reverseList(secondhead);
        return result;
    }

    //复制于Q206，反转链表操作
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    //使用快慢指针法，找到链表的中点
    public ListNode endOfLinklist(ListNode head){
        //快指针和慢指针
        ListNode fast = head;
        ListNode slow = head;
        //快指针每次走两步，慢指针走一步，如果是奇数慢指针即为中点，如果是偶数，则慢指针的下一个节点为中点
        while (fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
