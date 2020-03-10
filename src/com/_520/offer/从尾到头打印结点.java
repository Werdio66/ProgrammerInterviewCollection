package com._520.offer;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class 从尾到头打印结点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

      public int[] reversePrint(ListNode head) {
          List<Integer> list = new ArrayList<>();

          while(head != null){
              list.add(0, head.val);
              head = head.next;
          }

          int[] res = new int[list.size()];

          int index = 0;
          for (Integer num : list) {
              res[index++] = num;
          }
          return res;
    }

}
