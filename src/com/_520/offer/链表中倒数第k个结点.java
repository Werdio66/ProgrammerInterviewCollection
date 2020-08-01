package com._520.offer;

/**
 *  输入一个链表，输出该链表中倒数第k个结点。
 *
 *  思路：
 *      1、因为是倒数 k 个结点，所以我们可以定义俩个指针，快指针先走 k 个单位，然后和慢指针一起走
 *      这样就可以保证快指针遍历完的时候，慢指针指向的位置就是倒数第 k 个结点
 */
@SuppressWarnings("all")
public class 链表中倒数第k个结点 {

    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (k > 0){
            fast = fast.next;
            k--;

            // k 值过大
            if (fast == null && k > 0){
                return null;
            }
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        链表中倒数第k个结点 l = new 链表中倒数第k个结点();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode node = l.getKthFromEnd(listNode1, 1);
        System.out.println(node.val);
    }
}
