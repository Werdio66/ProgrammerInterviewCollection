package com._520.tree;

/**
 *  判断一颗二叉树是不是 AVL 树
 */
public class IsBalance {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBalance(TreeNode root) {

        if (root == null){
            return true;
        }

        // 查看左子树的深度
        int left = getHeight(root.left);
        // 查看右子树的深度
        int right = getHeight(root.right);

        // 判断是否为 AVL 数
        if (Math.abs(left - right) > 1){
            return false;
        }

        // 递归去判断左右子树是否是 AVL 树
        return isBalance(root.left) && isBalance(root.right);
    }

    private int getHeight(TreeNode node){
        if (node == null){
            return 0;
        }
        // 递归去计算深度
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode4.left = treeNode6;

        System.out.println(new IsBalance().isBalance(treeNode));
    }
}
