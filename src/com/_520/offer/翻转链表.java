package com._520.offer;

/**
 *  输入一个链表，反转链表后，输出新链表的表头。
 *
 *  思路：
 *      1、使用中间指针保存下一个结点的值
 *          例如对 1->2->3->4->5 翻转，
 *          head 指针指向 1, next 指针保存下一个结点值 2
 *          head 指向前一个结点 pre，刚开始 pre 为 null，将 pre 指向 head 1
 *          将 head 更新为 2，然后使用 next 保存下一个结点 3
 *          开始翻转，head 指向前一个结点 1，pre 指向 head 2，head 指向新结点 3
 *          翻转后的结果为 1<-2 3->4->5
 *          重复上述过程
 */
@SuppressWarnings("all")
public class 翻转链表 {

    public ListNode reverseList(ListNode head) {

        if (head.next == null || head.next == null){
            return head;
        }

        ListNode cur = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return cur;

    }

    /**
     *  双指针
     */
    public ListNode reverseList1(ListNode head) {

        ListNode pre = null;
        ListNode temp = null;
        ListNode cur = head;

        while (cur != null){
            // 记录当前结点的下一个结点
            temp = cur.next;
            // 反转
            cur.next = pre;
            // 下移
            pre = cur;
            // 指向下一个结点
            cur = temp;
        }


        return pre;
    }

    public static void main(String[] args) {
        翻转链表 f = new 翻转链表();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode = f.reverseList(listNode1);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
