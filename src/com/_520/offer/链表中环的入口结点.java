package com._520.offer;

/**
 *
 * 思路：
 *      1、
 *
 * @author Werdio丶
 * @since 2020-08-13 07:58:31
 */
public class 链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead){

        ListNode fast = pHead;
        ListNode slow = pHead;

        // 寻找相遇结点
        while (fast != null &&  slow != null){

            fast = fast.next.next;
            slow = slow.next;

            if (fast != null &&  slow != null && fast.val == slow.val){
                break;
            }
        }
        // 说明没有环
        if (fast == null){
            return null;
        }

        fast = pHead;
        // 相遇点就是入口点
        while (fast.val != slow.val){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
