package com.letcode.linklist;

/**
 * 题目：Q206 反转链表
 * 描述：反转一个单链表。
 * @author xiaoazhou
 * 2020年5月11日09:40:02
 * 补充：可以使用递归的方式实现
 */
public class Q206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;   //node之前的节点
        ListNode curr = head;   //现在所指的节点，初始为head
        ListNode next;   //现在所指的节点，初始为head
        while (curr != null){   //循环直到链表最后
            next = curr.next;   //指向改变后，三个节点分别后移一位
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;  //返回的pre就指向新的head
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)      //如果已经是最后一个节点 直接返回
            return head;
        ListNode p = reverseList1(head.next);       //原链表的尾结点，变为新链表的头节点，并层层返回
        head.next.next = head;                      //当前节点的next的指向变为当前节点，完成反转
        head.next = null;                          //当前节点的next置为null，防止出现循环链表
        return p;                                  //层层返回新链表的头结点
    }
}
