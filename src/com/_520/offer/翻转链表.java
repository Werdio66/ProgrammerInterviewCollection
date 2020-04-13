package com._520.offer;

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
