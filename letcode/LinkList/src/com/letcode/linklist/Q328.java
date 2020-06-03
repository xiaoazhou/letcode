package com.letcode.linklist;

/**
 * Q328 奇偶链表
 * 题目描述：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 2020年5月13日17:02:39
 * @author xiaoazhou
 */
public class Q328 {    //使用了多余的节点
    public ListNode oddEvenList(ListNode head) {
        ListNode odddummy = new ListNode(0);
        ListNode oddhead = odddummy;
        ListNode evendummy = new ListNode(0);
        ListNode evenhead = evendummy;
        int count = 0;
        while (head != null){
            count ++;
            if (count%2 == 1){
                oddhead.next = head;
                oddhead = oddhead.next;
            }else if (count%2 == 0){
                evenhead.next = head;
                evenhead = evenhead.next;
            }
            head = head.next;
        }
        oddhead.next = evendummy.next;
        return odddummy.next;
    }

    public ListNode oddEvenList1(ListNode head) { //官方解法，不使用多余节点

            if (head == null) return null;
            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }

            odd.next = evenHead;
            return head;
        }

}
