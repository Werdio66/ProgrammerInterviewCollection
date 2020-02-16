package com._520.tree;

/**
 *  创建一颗 AVL 树
 */
public class CreatAVLTree {

    public static void main(String[] args) {
        AVL avl = new AVL();

        for (int i = 0; i < 10; i++) {
            avl.add(new TreeNode(i));
        }

        avl.getRoot().orderTree();
    }
    static class AVL{
        TreeNode root;

        public void add(TreeNode node){
            if (root == null){
                root = new TreeNode(node.val);
                return;
            }

            root.add(node);
        }

        public TreeNode getRoot() {
            return root;
        }
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }

        /**
         *  中序遍历
         */
        public void orderTree(){
            if (this.left != null){
                this.left.orderTree();
            }
            System.out.println(this.val + "   ");
            if (this.right != null){
                this.right.orderTree();
            }
        }

        /**
         *  新增结点
         */
        public void add(TreeNode node){

            // 新加结点值大于根结点，去右子树添加
            if (node.val >= this.val){
                // 右子树为空，直接加上
                if (this.right == null){
                    this.right = node;
                }else {
                    // 去右子树中递归，找到合适的位置添加
                    this.right.add(node);
                }
            }else {
                // 在左子树添加

                // 左子树为空，直接加上
                if (this.left == null){
                    this.left = node;
                }else {
                    // 递归去添加
                    this.left.add(node);
                }
            }


            //如果左子树的高度 - 右子树的高度 > 1，右旋
            if (this.getLeftTreeHeight() - this.getRightTreeHeight() > 1){

                // 判断当前结点的左子树是否需要旋转
                if (this.left != null && this.left.getRightTreeHeight() - this.left.getLeftTreeHeight() > 1){
                    // 先需要进行左子树的左旋
                    this.left.leftWhirl();
                }
                // 右旋
                this.rightWhirl();
            }

            // 如果右子树的高度 - 左子树的高度 > 1，左旋
            if (this.getRightTreeHeight() - this.getLeftTreeHeight() > 1){
                // 判断当前结点的右子树是否需要旋转
                if (this.right != null && this.right.getRightTreeHeight() - this.right.getLeftTreeHeight() > 1){
                    // 先需要进行右子树的右旋
                    this.right.rightWhirl();
                }
                this.leftWhirl();
            }
        }

        /**
         *
         * @return  左子树的高度
         */
        private int getLeftTreeHeight(){
            return this.left == null ? 0 : this.left.getTreeHeight();
        }

        /**
         *
         * @return  右子树的高度
         */
        private int getRightTreeHeight(){
            return this.right == null ? 0 : this.right.getTreeHeight();
        }

        /**
         *  获取指定结点的高度
         */
        private int getTreeHeight(){
            return Math.max(this.left == null ? 0 : this.left.getTreeHeight(),
                    this.right == null ? 0 : this.right.getTreeHeight()) + 1;
        }

        /**
         *  左旋
         */
        private void leftWhirl(){
            // 1.创建一个新的结点，值为当前结点的值
            TreeNode treeNode = new TreeNode(this.val);
            // 2.新结点的左结点为当前结点的左结点
            treeNode.left = this.left;
            // 3.新结点的右结点为当前结点的右结点的左结点
            treeNode.right = this.right.left;
            // 4.当前结点的左结点为新结点
            this.left = treeNode;
            // 5.当结点的值为右结点的值
            this.val = this.right.val;
            // 6.当结点的右结点为当前结点右结点的右结点
            this.right = this.right.right;
        }

        /**
         *  右旋
         */
        private void rightWhirl(){
            // 1.创建一个新结点，结点值为当前结点
            TreeNode treeNode = new TreeNode(this.val);
            // 2.将新结点的左子结点设置为当前结点的左结点的右结点
            treeNode.left = this.left.right;
            // 3.将新结点的右结点设置为当前结点的右结点
            treeNode.right = this.right;
            // 4.将当前结点的右结点设置为新的结点
            this.right = treeNode;
            // 5.当前结点的值为左结点的值
            this.val = this.left.val;
            // 6.将当前结点的左结点设置为当前结点的左结点的左结点
            this.left = this.left.left;
        }
    }




}
