package com.vnaidu;

public class BinaryTreeRightView {

    private BTNode root;
    private static int maxLevel = 0;

    private void rightViewUtil(BTNode node, int level) {

        //This approach is done using depth first search (DFS)
        if (node == null) {
            return;
        }

        // If this is the first node of its level
        if (maxLevel < level) {
            System.out.println(" " + node.data);
            maxLevel = level;
        }

        // Recur for left and right subtrees
        rightViewUtil(node.right, level + 1);
        rightViewUtil(node.left, level + 1);
    }

    // A wrapper over leftViewUtil()
    private void rightView()
    {
        rightViewUtil(root, 1);
    }

    /* testing for example nodes */
    public static void main(String[] args)
    {
        /* creating a binary tree and entering the nodes */
        BinaryTreeRightView tree = new BinaryTreeRightView();
        tree.root = new BTNode(12);
        tree.root.left = new BTNode(10);
        tree.root.right = new BTNode(30);
        tree.root.right.left = new BTNode(25);
        tree.root.right.right = new BTNode(40);

        tree.rightView();
    }
}
