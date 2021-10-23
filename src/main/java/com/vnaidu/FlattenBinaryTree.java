package com.vnaidu;

import java.util.LinkedList;

public class FlattenBinaryTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    LinkedList list = new LinkedList();

    public void flatten(TreeNode node) {

       helper(node);

    }

    private TreeNode helper(TreeNode node) {
        if(node == null) {
            return node;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        if(left != null) {
            TreeNode lastLeft = helper(left);
            node.right = left;
            node.left = null;
            node = lastLeft;
        }

        if(right != null) {
            TreeNode lastRight = helper(right);
            node.right = right;
            node = lastRight;
        }


        return node;
    }
    public static void main(String[] args)
    {
        /* creating a binary tree and entering the nodes */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);

        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        flattenBinaryTree.flatten(tree);
        flattenBinaryTree.printTree(tree);
    }

    public void printTree(TreeNode root) {
        if(root == null ) return;
        System.out.println(root.val);
//        printTree(root.left);
        printTree(root.right);
    }
}
