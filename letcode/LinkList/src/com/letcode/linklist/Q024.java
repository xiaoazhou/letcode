package com.letcode.linklist;

/**
 * Q024 两两交换链表中的节点
 * 题目描述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 2020年5月15日20:23:00
 * @author  xiaozhou
 */
public class Q024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode pre = dummyhead;


        while (head != null && head.next!= null){
            ListNode curr = head;             //目前位置的第一个指针
            ListNode next = head.next;        //目前位置的第二个指针

            curr.next = next.next;           //交换节点
            next.next = curr;
            pre.next = next;
            pre = curr;                      //前节点应变为原来的第一个指针
            head = pre.next;                 //当前节点后移
        }

        return dummyhead.next;
    }
}
