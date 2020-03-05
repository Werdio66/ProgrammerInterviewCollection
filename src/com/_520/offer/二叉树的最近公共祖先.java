package com._520.offer;

/**
 *  如果 p，q，是 root 结点的左右子结点，则 root 结点是最近公共祖先
 *  如果 p，q 都是 root 结点的左子结点，则递归左子树
 *  如果 p，q 都是 root 结点的右子结点，则递归右子树
 */
@SuppressWarnings("all")
public class 二叉树的最近公共祖先 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode == null){
            return rightNode;
        }

        if (rightNode == null){
            return leftNode;
        }

        return root;
    }

}
