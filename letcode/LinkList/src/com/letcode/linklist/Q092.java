package com.letcode.linklist;

public class Q092 {

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n)
                return head;
            int count = 1;
            ListNode Copyhead = head;
            ListNode FirstNode = null;
            ListNode lastpre;
            while (count != n){
                if (count == m-1)
                    FirstNode = Copyhead;
                Copyhead = Copyhead.next;
                count++;
            }
            ListNode last = Copyhead.next;
            if (FirstNode != null){
                lastpre = FirstNode.next;
                FirstNode.next = reverseList(FirstNode.next,Copyhead);
            }
            else {
                lastpre = head;
                head = reverseList(head,Copyhead);
            }
            lastpre.next = last;
            return head;
        }

        public ListNode reverseList(ListNode head,ListNode last) {
            if (head == last)                             //如果已经是最后一个节点 直接返回
                return head;
            ListNode p = reverseList(head.next,last);    //原链表的尾结点，变为新链表的头节点，并层层返回
            head.next.next = head;                      //当前节点的next的指向变为当前节点，完成反转
            head.next = null;                          //当前节点的next置为null，防止出现循环链表
            return p;                                  //层层返回新链表的头结点
        }


}
