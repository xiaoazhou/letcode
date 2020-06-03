package com.letcode.linklist;

/**
 * Q82 删除排序链表中的重复元素2
 * 题目描述：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class Q082 {//其实可以不需要next节点
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);           //设置一个虚节点指向头结点
        dummy.next = head;
        ListNode pre = dummy;                          //pre为当前节点之前的一个节点
        ListNode next = head.next;                     //next表示当前节点之后的一个节点
        Boolean flag = true;                           //标志位表示当前节点的值是否为不重复的，true表示不重复

        while (next!= null){
            while (next != null && head.val == next.val){   //如果有重复，循环删除所有重复值
                next = next.next;                           //删除当前的节点，将pre指向next
                pre.next = next;
                flag = false;                               //有重复值，将flag更改为false
            }
            if (flag)                                      //如果不重复，移动pre，否则 pre不改变
                pre = head;
            flag = true;                                  //重置标志位
            head = next;
            if (next != null)                             //next后移
                next = next.next;
        }
        return dummy.next;
    }
}
