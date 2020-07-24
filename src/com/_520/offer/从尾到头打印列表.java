package com._520.offer;

import java.util.ArrayList;

/**
 * @author Werdio丶
 * @since 2020-07-24 07:35:31
 */
public class 从尾到头打印列表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null){
            // 使用 list 中的方法，每次都在第一次位置加入元素，底层使用 System.arraycopy，
            // 将第一个位置及以后的数都向后移动，在吧新的数据插入到第一个位置
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }


    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        printListFromTailToHeadCore(list, listNode);
        return list;
    }

    public void printListFromTailToHeadCore(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null){
            return;
        }
        printListFromTailToHeadCore(list, listNode.next);

        list.add(listNode.val);
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        从尾到头打印列表 c = new 从尾到头打印列表();
        System.out.println(c.printListFromTailToHead1(listNode1));
    }
}
