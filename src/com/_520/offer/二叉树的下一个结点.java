package com._520.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 *  思路：
 *      1、暴力破解，直接根据给定的结点，找到根结点，然后中序遍历，并将中序遍历结点加入 list，然后在挨个判断
 *      2、分情况讨论
 *          1、当前结点有右子结点，那么下一个结点就是右子结点的最左结点
 *          2、当前结点没有右子结点，但是它是父结点的左子结点，那么下一个就是父结点
 *          3、当前结点没有右子结点，但是它是父结点的右子结点，那么下一个就是一直回溯到父结点是其父结点的左结点
 *          4、父结点是根结点的右结点，null
 * @author Werdio丶
 * @since 2020-08-14 08:34:03
 */
public class 二叉树的下一个结点 {

    private List<TreeLinkNode> list = new ArrayList<>();

    // 1
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        TreeLinkNode root = pNode;
        while (root.next != null){
            root = root.next;
        }
        orderTree(root);

        int index = 0;
        while (index < list.size()){
            if (index + 1 < list.size() && pNode.val == list.get(index).val){
                return list.get(index + 1);
            }
            index++;
        }

        return null;
    }

    private void orderTree(TreeLinkNode root){
        if (root.left != null){
            orderTree(root.left);
        }
        list.add(root);
        if (root.right != null){
            orderTree(root.right);
        }
    }

    // 2
    public TreeLinkNode GetNext1(TreeLinkNode pNode){

        // 1、有右子结点
        if (pNode.right != null){
            TreeLinkNode root = pNode.right;

            while (root.left != null){
                root = root.left;
            }

            return root;
        }

        // 2、没有右子结点，且当前结点是父结点的左子结点

        TreeLinkNode parent = pNode.next;
        // 当前结点不是 root 结点
        if (parent != null){
            if (parent.left == pNode){
                return parent;
            }else {
                // 3、当前结点是父结点的右结点
                TreeLinkNode root = parent.next;
                while (root != null && root.left != parent){
                    root = root.next;
                    parent = parent.next;
                }

                return root;
            }
        }

        return null;
    }
}
