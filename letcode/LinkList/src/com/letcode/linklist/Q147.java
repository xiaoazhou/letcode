package com.letcode.linklist;

/**
 * Q147 对链表进行插入排序
 * 题目描述：对链表进行插入排序。
 * 2020年5月16日18:05:53
 * @author xiaoazhou
 */
public class Q147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)                                     //如果是空，直接返回
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);     //虚节点为了不影响排序，必须设置为最小值
        dummy.next = head;
        while (head.next != null) {                           //如果当前节点的下一个节点存在，则一直进行
            if (head.next.val >= head.val){            //加入下一个节点，目前已进行的链表仍然有序。则目前节点后移
                head = head.next;
            } else {                                  //加入下一个节点后，链表无序，则对下一个节点进行插入操作
                ListNode next = insert(head.next,dummy);  //返回的是还未排序链表的头结点
                //其实函数也可以没有返回值，只需要先记录下未排序链表的头结点就可以
                head.next = next;                     //将目前节点与剩下未排序的链表连接上
            }
        }

        return dummy.next;
    }

    public ListNode insert(ListNode curr,ListNode dummy){  //将curr节点，插入到以dummy头结点的链表中去
        ListNode next = curr.next;                      //记录未排序链表的头结点，方便返回
        ListNode copyhead = dummy;                      //插入操作中正遍历的节点
        while (true){                              //一定存在一个正确位置，所以设置true即可
            //while (copyhead.next != curr && copyhead.next != null){
            //为了保险起见，也可以设置条件
            if (curr.val >= copyhead.val && curr.val <= copyhead.next.val){ //满足条件
                curr.next = copyhead.next;                //将节点插入到正确位置
                copyhead.next =curr;
                return next;
            }else {                                    //不满足条件
                copyhead = copyhead.next;              //继续遍历
            }
        }
    }
}
