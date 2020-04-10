package com._520.offer;

@SuppressWarnings("all")
public class 链表中倒数第k个结点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (k != 0){
            fast = fast.next;
            if (fast == null){
                return head;
            }
            k--;
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

        ListNode node = l.getKthFromEnd(listNode1, 4);
        System.out.println(node.val);
    }
}
