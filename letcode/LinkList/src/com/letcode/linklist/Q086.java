package com.letcode.linklist;

/**
 * Q086 分割链表
 * 题目描述：给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 2020年5月13日16:18:44
 * @author xiaoazhou
 */

public class Q086 {
    public ListNode partition(ListNode head, int x) {
        ListNode mindummy = new ListNode(0);
        mindummy.next = null;                         //双指针，mindummy表示小于val的链表虚节点
        ListNode minhead = mindummy;
        ListNode maxdummy = new ListNode(0);       //maxdummy表示大于val的链表虚节点
        maxdummy.next = null;
        ListNode maxhead = maxdummy;
        while (head != null){                         //遍历整个链表
            if (head.val < x){                       //如果小于val加入到min链表中去
                minhead.next = head;
                minhead = minhead.next;
            }else {
                ListNode max = new ListNode(head.val);//如果大于val加入到max链表中去
                max.next = null;
                maxhead.next = head;
                maxhead = maxhead.next;
            }
                head = head.next;
        }
        minhead.next = maxdummy.next;                //将min链表与max链表连接起来
        maxhead.next = null;                         //避免出现循环链表
        return mindummy.next;
    }
}
