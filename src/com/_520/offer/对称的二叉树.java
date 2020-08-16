package com._520.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Werdio丶
 * @since 2020-08-16 07:06:48
 */
public class 对称的二叉树 {

    public boolean isSymmetrical(TreeNode pRoot) {

        LinkedList<TreeNode> list = new LinkedList<>();

        list.add(pRoot);
        list.add(pRoot);

        while (!list.isEmpty()){
            TreeNode node1 = list.removeFirst();
            TreeNode node2 = list.removeFirst();

            if (node1 == null && node2 == null){
                continue;
            }

            if (node1 == null || node2 == null){
                return false;
            }

            if (node1.val != node2.val){
                return false;
            }

            list.add(node1.left);
            list.add(node2.right);

            list.add(node1.right);
            list.add(node2.left);
        }

        return true;
    }

    public boolean isSymmetrical1(TreeNode pRoot) {
       return pRoot == null || adjust(pRoot, pRoot);
    }

    public boolean adjust(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }

        if (t1 == null || t2 == null){
            return false;
        }

        if (t1.val != t2.val){
            return false;
        }

        return adjust(t1.left, t2.right) && adjust(t1.right, t2.left);

    }
}
