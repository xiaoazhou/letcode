package com.letcode.linklist;

/**
 * Q083 删除排序链表中的重复元素
 * 题目描述：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 2020年5月12日23:46:45
 * 无难度
 */

public class Q083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next==null)
            return head;

        ListNode curr = head;
        ListNode temp;
        while (curr.next != null){
            if (curr.next.val == curr.val){
                temp = curr.next;
                curr.next = temp.next;
                temp.next = null;
            }else{
            curr = curr.next;
            }
        }
        return head;
    }
}
