package com._520.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 *  思路：
 *      树的层次遍历，使用队列
 *
 * @author Werdio丶
 * @since 2020-08-03 09:30:16
 */
public class 从上往下打印二叉树 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }

        return list;
    }
}
