package com.vnaidu;

public class BinaryTreeDFS extends Base {
    // Preorder DFS (Root → Left → Right)
    public void preorder(BTNode root) {
        if (root == null) return;
        logger.info(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder DFS (Left → Root → Right)
    public void inorder(BTNode root) {
        if (root == null) return;
        inorder(root.left);
        logger.info(root.data + " ");
        inorder(root.right);
    }

    // Postorder DFS (Left → Right → Root)
    public void postorder(BTNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        logger.info(root.getData() + " ");
    }

    public static void main(String[] args) {
        BinaryTreeDFS tree = new BinaryTreeDFS();

        // Constructing the tree
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);

        logger.info("Preorder: ");
        tree.preorder(root);

        logger.info("Inorder: ");
        tree.inorder(root);

        logger.info("Postorder: ");
        tree.postorder(root);
    }
}
