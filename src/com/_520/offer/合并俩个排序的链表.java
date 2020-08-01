package com._520.offer;

/**
 *  合并排序的链表
 *
 *  思路：
 *      新建一个 head 结点，对俩个链表的结点进行比较，head 指向小的，最后将剩余的挂在后面
 */
@SuppressWarnings("all")
public class 合并俩个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(-1);
        ListNode cur = res;

        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                // l2 小，将 l2 挂在后面
                cur.next = l2;
                l2 = l2.next;
            }else {
                // l1 小，将 l1 挂在后面
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        // l1 有剩余
        if (l1 != null){
            cur.next = l1;
        }

        // l2 有剩余
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
