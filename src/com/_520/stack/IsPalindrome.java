package com._520.stack;

import java.util.Stack;

/**
 *  回文串
 */
public class IsPalindrome {
    public static boolean isPalindrome(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        Stack<Integer> stack = new Stack<>();

        while (fast != null){
            if (fast.next == null){
                slow = slow.next;
                break;
            }
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        while (slow != null){
            if (slow.val != stack.pop()){
                return false;
            }
            slow = slow.next;
        }

        return true;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        System.out.println(isPalindrome(listNode));
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


