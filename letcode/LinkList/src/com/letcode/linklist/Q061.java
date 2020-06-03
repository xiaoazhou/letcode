package com.letcode.linklist;

/**
 * Q061 旋转链表
 * 题目描述： 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 2020年5月17日16:54:44
 * @author xiaoazhou
 */
public class Q061 {
    //我的方法 时间很长，有优化空间，思维定式了
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < k;i++){
            head = head.next;
            if (head == null)
                head = dummy.next;
        }
        if (head == dummy.next)
            return head;
        while (head.next != null){
            head = head.next;
            pre = pre.next;
        }
        ListNode copyhead = dummy.next;
        dummy.next = pre.next;
        pre.next = null;
        head.next =  copyhead;

        return dummy.next;
    }

    //其实本质就是将链表头尾相连，找到一个节点位置，断开链表。
    public ListNode rotateRight1(ListNode head, int k) {
            if (head == null)
                return null;

            ListNode copy = head;                      //复制一份head
            int len = 1;                               //len链表长度
            while (copy.next != null){                 //遍历整个链表，得到链表长度
                len++;
                copy = copy.next;
            }
            copy.next = head;                         //将链表的尾部与头部相连
            int n = k % len;                          //n表示在第几个节点后断开

            while (len-- != n){                       //找到要断开的那个节点
              copy = copy.next;
            }
            head = copy.next;                         //head更改为新的链表头
            copy.next = null;                         //断开节点

            return head;


    }


}
