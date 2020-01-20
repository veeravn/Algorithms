package com.vnaidu;

public class BinaryTreeFindMaxValue {

    private static BTNode root;

    // Returns the max value in a binary tree
    private static int findMax(BTNode node)
    {
        if (node == null)
            return Integer.MIN_VALUE;

        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }
    // Returns the min value in a binary tree
    private static int findMin(BTNode node)
    {
        if (node == null)
            return Integer.MAX_VALUE;

        int res = node.data;
        int lres = findMin(node.left);
        int rres = findMin(node.right);

        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }


    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        BinaryTreeFindMaxValue.root = new BTNode(2);
        BinaryTreeFindMaxValue.root.left = new BTNode(7);
        BinaryTreeFindMaxValue.root.right = new BTNode(5);
        BinaryTreeFindMaxValue.root.left.right = new BTNode(6);
        BinaryTreeFindMaxValue.root.left.right.left = new BTNode(1);
        BinaryTreeFindMaxValue.root.left.right.right = new BTNode(11);
        BinaryTreeFindMaxValue.root.right.right = new BTNode(9);
        BinaryTreeFindMaxValue.root.right.right.left = new BTNode(4);

        System.out.println("Maximum element is " +
                BinaryTreeFindMaxValue.findMax(BinaryTreeFindMaxValue.root));
        System.out.println("Minimum element is " +
                BinaryTreeFindMaxValue.findMin(BinaryTreeFindMaxValue.root));
    }

}
