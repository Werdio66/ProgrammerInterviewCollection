package com._520.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Werdio丶
 * @since 2020-08-16 07:54:55
 */
public class 把二叉树打印成多行 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(pRoot);

        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> res = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);

                if (node.left != null){
                    queue.offer(node.left);
                }

                if (node.right != null){
                    queue.offer(node.right);
                }
            }

            list.add(res);

        }

        return list;
    }
}
