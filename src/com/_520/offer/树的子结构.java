package com._520.offer;

/**
 *  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 *  思路：
 *      1、先判断当前根结构开始是否满足
 *      2、递归的去左右结点查找
 *          每一次判断的时候，挨个判断每一个结点
 *
 * @author Werdio丶
 * @since 2020-08-01 08:13:14
 */
@SuppressWarnings("all")
public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }

        // 判断当前 root 结点开始是否满足
        if (judement(root1, root2)){
            return true;
        }

        // 在左边和右边查找
        return judement(root1.left, root2) || judement(root1.right, root2);
    }

    private boolean judement(TreeNode root, TreeNode sub) {

        // 子结构判断完了，说明符合要求
        if (sub == null){
            return true;
        }

        // 必须先判断子树，如果先判断原树，会导致在子树和原树的子结构恰好相等，原树没有剩余的情况下返回 false
        if (root == null){
            return false;
        }

        if (root.val == sub.val){
            // 判断左子树和右子树
            return judement(root.left, sub.left) && judement(root.right, sub.right);
        }

        return false;
    }
}
