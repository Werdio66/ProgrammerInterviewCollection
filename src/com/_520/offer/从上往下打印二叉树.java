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

    /**
     *  可以知道树的深度
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();

            while (size-- != 0){
                TreeNode node = queue.poll();

                list.add(node.val);

                if (node.left != null){
                    queue.offer(node.left);
                }

                if (node.right != null){
                    queue.offer(node.right);
                }
            }

            level++;
            System.out.println(level);

        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(11);
        TreeNode treeNode8 = new TreeNode(19);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode6.right = treeNode8;

        System.out.println(PrintFromTopToBottom1(treeNode1));
    }
}
