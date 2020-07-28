package com._520.offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 思路：前序遍历的每一个值都是当前子树的根结点，每一个根结点在中序遍历数组中将数组分为俩段，所以可以使用递归
 *
 * @author Werdio丶
 * @since 2020-07-28 17:28:37
 */
@SuppressWarnings("all")
public class 重建二叉树 {

    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {

        TreeNode treeNode = new TreeNode(pre[0]);

        return reConstructBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length);
    }

    /**
     *  递归去构建树
     *  也可以使用数组拷贝，但是需要额外的空间
     *
     * @param pre                   前序遍历数组
     * @param pre_start             起始位置
     * @param pre_end               结束位置
     * @param in                    中序遍历数组
     * @param in_start              中序起始位置
     * @param in_end                中序结束位置
     * @return
     */
    private TreeNode reConstructBinaryTreeCore(int[] pre, int pre_start, int pre_end, int[] in, int in_start, int in_end){

        if (pre_start > pre_end || in_start > in_end){
            return null;
        }
        // 根结点的值是前序遍历第一个
        TreeNode root = new TreeNode(pre[pre_start]);

        for (int i = in_start; i <= in_end; i++) {
            if (in[i] == pre[pre_start]){
                // pre_end = i - in_start + pre_start : i - in_start 计算左子树的个数 + 前序的起始位置
                root.left = reConstructBinaryTreeCore(pre, pre_start + 1, i - in_start + pre_start, in, in_start, i - 1);

                root.right = reConstructBinaryTreeCore(pre, i - in_start + pre_start + 1, pre_end, in, i + 1, in_end);
                break;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        重建二叉树 c = new 重建二叉树();

        TreeNode treeNode = c.reConstructBinaryTree(pre, in);

        printPre(treeNode);
    }

    private static void printPre(TreeNode treeNode){
        System.out.print(treeNode.val + " => ");
        if (treeNode.left != null){
            printPre(treeNode.left);
        }
        if (treeNode.right != null){
            printPre(treeNode.right);
        }
    }
}
