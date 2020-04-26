package com._520.offer;

@SuppressWarnings("all")
public class 合并俩个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(-1);
        ListNode cur = res;

        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        if (l1 != null){
            cur.next = l1;
        }

        if (l2 != null){
            cur.next = l2;
        }
        return res.next;
    }

    public static void main(String[] args) {

        合并俩个排序的链表 h = new 合并俩个排序的链表();

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);

        l1.next = l11;
        l11.next = l12;

        l2.next = l21;
        l21.next = l22;

        ListNode listNode = h.mergeTwoLists(l1, l2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
