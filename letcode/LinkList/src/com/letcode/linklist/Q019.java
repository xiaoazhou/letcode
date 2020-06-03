package com.letcode.linklist;

/**
 *Q019 删除链表的倒数第N个节点
 *题目描述： 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 2020年5月17日16:40:00
 * @author xiaoazhou
 */

public class Q019 {
    //使用双指针法，一次遍历完成删除链表的倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int count = 1;                        //两指针间隔，初始时间隔为1

        while (head != null){                //遍历到链表尾部，此时pre所指为要删除节点的前一个节点
            if (count != n + 1){             //如果此时还没有相差为n+1距离，则只需移动head，使其满足
                head = head.next;
                count++;
            }else {                         //已经满足后 pre和head 双指针开始一起移动
                head = head.next;
                pre = pre.next;
            }
        }

        pre.next = pre.next.next;           //将要删除的节点删除
        return dummy.next;
    }
}

