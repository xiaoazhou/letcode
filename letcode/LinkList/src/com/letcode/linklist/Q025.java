package com.letcode.linklist;

public class Q025 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;                                 //如果是1，则链表不变
        int count = 1;                                   //计时器，初始时遍历了head一个节点，为1
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode pre = dummyhead;                      //前节点，标识着已经完成反转的链表中的最后一个节点
        ListNode curr = head;                          //当前正在遍历的节点
        while (curr != null){
            if (count % k == 0){                       //目前已经到了一组的最后一个位置
                reverseList1(head,curr);               //反转这一组中的所有元素，将链表分成了已经完成反转 和 当前反转组 两部分
                count++;
                pre.next = curr;                       //将两组连接起来
                pre = head;                            //pre变更，此时的head已经变为完成反转部分的最后一个节点
                head = pre.next;                       //新的head为未反转的部分第一个节点
                curr = head;                           //目前遍历的节点变为新的部分第一个节点
            }
            else{                                     //没有到一组的末尾，继续遍历
                count++;
                curr = curr.next;
            }
        }
        return dummyhead.next;
    }


    public ListNode reverseList1(ListNode head,ListNode curr) {
        if (head == curr)                                           //递归的反转元素，返回的是未完成反转部分的第一个节点
            return curr.next;
        ListNode p = reverseList1(head.next,curr);
        head.next.next = head;                                      //完成反转
        head.next = p;                                              //层层返回 下一组的第一个节点，要将反转后的部分连接到未反转的部分上去
        return p;
    }
}
