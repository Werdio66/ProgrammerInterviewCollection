package com._520.tree;

/**
 *  创建一颗 AVL 树
 */
public class CreatAVLTree {

    public static void main(String[] args) {
        AVL avl = new AVL();

        for (int i = 0; i < 3; i++) {
            avl.add(new TreeNode(i));
        }

        avl.getRoot().orderTree();

        avl.delete(1);
        avl.delete(0);
        System.out.println();
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

        /**
         *  删除结点
         */
        public void delete(int value){
            //
            if (root == null){
                System.out.println("没有结点");
                return;
            }

            if (root.left == null && root.right == null){
                root = null;
                return;
            }

            // 找到要删除的结点
            TreeNode delNode = search(value);
            if (delNode == null) {
                System.out.println("没有找到要删除的结点");
                return;
            }
            // 找到父结点
            TreeNode parentNode = searchParent(value);

            // 1、删除的结点是叶子结点，直接将父结点的对应结点置空即可
            if (delNode.left == null && delNode.right == null){
                if (parentNode.left != null && parentNode.left.val ==value){
                    parentNode.left = null;
                }
                if (parentNode.right != null && parentNode.right.val == value){
                    parentNode.right = null;
                }
            }else if (delNode.left != null && delNode.right != null){
                // 3.删除结点有俩个子结点
                // 找到右子树中最小的一个替换删除结点，删除最小的结点
                // 找到左子树中最大的结点替换删除结点值，删除那个最大的结点
                delNode.val = searchMaxInLeftTree(delNode.left);
            }else {
                // 2.如果要删除的结点有一个子结点，删除的结点有可能是根结点

                // 删除结点有左子结点
                if (delNode.left != null){

                    if (parentNode != null){

                        // 删除结点是父结点的左结点
                        if (delNode.val == parentNode.left.val){
                            parentNode.left = delNode.left;
                        }else {
                            // 删除结点是父结点的右结点

                            parentNode.right = delNode.left;
                        }
                    }else {
                        // 删除结点是根结点
                        root = delNode.left;
                    }


                }else {
                    // 删除结点有左结点

                    if (parentNode != null){
                        // 删除结点是父结的右子结点
                        if (delNode.val == parentNode.right.val){
                            parentNode.right = delNode.right;
                        }else {
                            parentNode.left = delNode.right;
                        }
                    }else {
                        // 删除结点是根结点

                        root = delNode.right;
                    }

                }
            }


        }

        private int searchMaxInLeftTree(TreeNode node) {

            while (node.right != null){
                node = node.right;
            }

            int value = node.val;

            delete(value);

            return value;
        }

        private TreeNode searchParent(int value) {
            return root.searchParent(value);
        }

        private TreeNode search(int value) {
            return root.search(value);
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
            System.out.print(this.val + "   ");
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


        public TreeNode search(int value) {
            if (value == this.val){
                return this;
            }else if (value > this.val){
                if (this.right != null){
                    return this.right.search(value);
                }else {
                    return null;
                }
            }else {
                if (this.left != null){
                    return this.left.search(value);
                }else {
                    return null;
                }
            }
        }

        public TreeNode searchParent(int value) {
            if ((this.left != null && this.left.val == value) || (this.right != null && this.right.val == value)){
                return this;
            }else {
                if (this.right != null && value > this.val){
                    return this.right.searchParent(value);
                }else if (this.left != null && value < this.val){
                    return this.left.searchParent(value);
                }else {
                    return null;
                }
            }
        }
    }




}
