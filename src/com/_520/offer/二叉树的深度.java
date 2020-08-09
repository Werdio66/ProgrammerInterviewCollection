package com._520.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路：
 * 1、在树的层次遍历中可以获取当前树的深度
 * 2、递归的去左右子树查找
 *
 * @author Werdio丶
 * @since 2020-08-09 07:44:54
 */
public class 二叉树的深度 {

    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public int TreeDepth1(TreeNode root) {

        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

            while (size-- != 0){
                TreeNode node = queue.poll();

                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null){
                    queue.add(node.right);
                }
            }

            level++;
        }

        return level;
    }
}
