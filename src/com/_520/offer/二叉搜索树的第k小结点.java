package com._520.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  思路：
 *      1、递归，因为二叉搜索树按中序遍历就是从小到大，然后获取第 k-1 个数就行了
 *      2、非递归，遍历的同时排除最小的数
 *
 * @author Werdio丶
 * @since 2020-08-16 08:02:55
 */
public class 二叉搜索树的第k小结点 {

    TreeNode KthNode(TreeNode pRoot, int k){
        List<TreeNode> list = new ArrayList<>();

        order(list, pRoot);

        if (k > list.size() || k <= 0){
            return null;
        }

        return list.get(k - 1);
    }

    private void order(List<TreeNode> list, TreeNode pRoot) {

        if (pRoot.left != null){
            order(list, pRoot.left);
        }

        list.add(pRoot);

        if (pRoot.right != null){
            order(list, pRoot.right);
        }
    }


    // 非递归
    TreeNode KthNode1(TreeNode pRoot, int k){

        LinkedList<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || pRoot != null){

            if (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }else {

                pRoot = stack.pop();

                if (--k == 0){
                    return pRoot;
                }

                pRoot = pRoot.right;
            }
        }

        return null;
    }
}
