package com._520.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *  思路：
 *      二叉搜索树特性，左子结点 < 根结点 < 右子结点
 *      我们只需要判断这个后序遍历的结果满不满足二叉搜索树即可
 *      可以采用分治的思想，判断每一颗子树是否满足
 *      1、找到左右子树的分界点
 *      2、判断右子树是不是都小于根结点
 *      3、递归的去查找
 *
 * @author Werdio丶
 * @since 2020-08-04 07:50:43
 */
public class 二叉搜索树后序遍历 {

    public static boolean VerifySquenceOfBST(int [] sequence) {

        return isBST(sequence, 0, sequence.length - 1);
    }

    private static boolean isBST(int[] sequence, int begin, int end) {

        if (begin >= end){
            return true;
        }

        int root = sequence[end];

        int position = 0;
        for (int i = begin; i <= end; i++) {
            // 找到左子树和右子树的分界点
            if (sequence[i] >= root){
                position = i - 1;
                break;
            }
        }

        // 查看右子树有没有比根结点小的值
        for (int i = position + 1; i < end; i++) {
            if (sequence[i] < root){
                return false;
            }
        }

        // 递归的去判断左子树和右子树是否满足
        return isBST(sequence, begin, position) && isBST(sequence, position + 1, end - 1);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(VerifySquenceOfBST(arr));
    }
}
