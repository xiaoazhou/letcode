package com.letcode.linklist;

/**
 * Q237 删除链表中的节点
 * 题目描述：请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 我做过最简单的题目。。。
 */
public class Q237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
