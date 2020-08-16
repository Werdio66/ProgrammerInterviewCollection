package com._520.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Werdio丶
 * @since 2020-08-16 07:18:30
 */
public class 按之字型打印二叉树 {

    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > resultList = new ArrayList<>();

        int level = 1;

        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(pRoot);


        while (!list.isEmpty()){

            ArrayList<Integer> res = new ArrayList<>();

            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.remove(0);
                res.add(node.val);


                if (node.left != null){
                    list.add(node.left);
                }

                if (node.right != null){
                    list.add(node.right);
                }
            }
            if (level % 2 == 0){
                Collections.reverse(res);
            }
            resultList.add(res);
            level++;
        }

        return resultList;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(11);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println(Print(treeNode1));
    }
}
