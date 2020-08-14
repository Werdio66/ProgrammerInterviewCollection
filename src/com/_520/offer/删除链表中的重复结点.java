package com._520.offer;

/**
 *
 *  思路：
 *      因为是排序的链表，所以可以定义俩个指针，挨个比较，如果有相同的，然后在查找相同数据的范围，最后删除
 *
 * @author Werdio丶
 * @since 2020-08-14 07:43:31
 */
public class 删除链表中的重复结点 {

    public ListNode deleteDuplication(ListNode pHead){

        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null){

            if (fast.next != null && fast.val == fast.next.val){
                while (fast.next != null && fast.val == fast.next.val){
                    fast = fast.next;
                }

                fast = fast.next;
                slow.next = fast;

            }else {
                slow = fast;
                fast = fast.next;

            }
        }

        return head.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        删除链表中的重复结点 s = new 删除链表中的重复结点();

        ListNode listNode = s.deleteDuplication(listNode1);

        while (listNode != null){
            System.out.print(listNode.val + " => ");
            listNode = listNode.next;
        }
    }
}
