package com.vnaidu;

public class BinaryTreeLeftView {

    private BTNode root;
    private static int maxLevel = 0;

    // recursive function to print left view
    private void leftViewUtil(BTNode node, int level)
    {
        // Base Case
        if (node == null) {
            return;
        }

        // If this is the first node of its level
        if (maxLevel < level) {
            System.out.println(" " + node.data);
            maxLevel = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    private void leftView()
    {
        leftViewUtil(root, 1);
    }

    /* testing for example nodes */
    public static void main(String[] args)
    {
        /* creating a binary tree and entering the nodes */
        BinaryTreeLeftView tree = new BinaryTreeLeftView();
        tree.root = new BTNode(12);
        tree.root.left = new BTNode(10);
        tree.root.right = new BTNode(30);
        tree.root.right.left = new BTNode(25);
        tree.root.right.right = new BTNode(40);

        tree.leftView();
    }
}
