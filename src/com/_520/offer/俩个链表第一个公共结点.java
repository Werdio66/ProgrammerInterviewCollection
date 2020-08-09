package com._520.offer;

/**
 *
 *  思路：
 *      因为俩个有可能在到达公共结点之前的长度不相等，导致最后没有找到公共结点
 *      所以我们可以在遍历完之后，在遍历一遍
 *      l1 + l2 = l2 + l1
 * @author Werdio丶
 * @since 2020-08-09 07:17:40
 */
public class 俩个链表第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode l1 = pHead1;
        ListNode l2 = pHead2;

        while (l1 != l2){
            l1 = l1.next;
            l2 = l2.next;

            if (l1 != l2){
                l1 = pHead2;
                l2 = pHead1;
            }
        }

        return l1;
    }
}
