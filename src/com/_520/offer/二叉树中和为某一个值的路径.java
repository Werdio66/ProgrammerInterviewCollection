package com._520.offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 *  思路：
 *      因为是从根结点到叶子结点的路径，所以我们可以从根结点开始计算路径和，然后递归的去遍历
 *
 * @author Werdio丶
 * @since 2020-08-04 08:24:13
 */
public class 二叉树中和为某一个值的路径 {

    // 存放最后的结果
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    // 存放路径
    private static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null){
            return res;
        }

        getPath(root, target, 0);
        return res;
    }

    private static void getPath(TreeNode root, int target, int current) {

        if (root == null){
            return;
        }

        current += root.val;
        // 加入当前路径值
        list.add(root.val);

        // 如果和为目标值且是叶子结点，将将它加入结果集中
        if (current == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
            // 删除最后一个结点
            list.remove(list.size() - 1);
            return;
        }
        // 递归从左边查找
        getPath(root.left, target, current);
        // 递归从右边查找
        getPath(root.right, target, current);
        // 递归完成之后需要删除最后一个结点
        list.remove(list.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println(FindPath(treeNode1, 16));
    }
}
