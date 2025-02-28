package com.vnaidu;

import java.util.*;

// Given a binary tree, implement an iterator which can return the tree node value in post-traverse order (cannot modify the tree):
/** Returns the next integer in the post-order traversal of the given binary tree.
 * For example, given a binary tree below,
 *        4
 *       / \
 *     2    6
 *    / \   / \
 *   1  3   5  7
 * the outputs will be 1, 3, 2, 5, 7, 6, 4.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PostOrderBinaryTreeIteratorImpl implements PostOrderBinaryTreeIterator {
    private Stack<TreeNode> stack;
    private TreeNode lastVisited;

    public PostOrderBinaryTreeIteratorImpl(TreeNode root) {
        stack = new Stack<>();
        lastVisited = null;
        if (root != null) {
            stack.push(root);
        }
    }
    @Override
    public int next() {
        while (hasNext()) {
            TreeNode curr = stack.peek();
            // If going down the tree
            if (lastVisited == null || lastVisited.left == curr || lastVisited.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    // Leaf node, process it
                    lastVisited = stack.pop();
                    return lastVisited.val;
                }
            }
            // If coming up from left subtree
            else if (curr.left == lastVisited) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    lastVisited = stack.pop();
                    return lastVisited.val;
                }
            }
            // If coming up from right subtree
            else if (curr.right == lastVisited) {
                lastVisited = stack.pop();
                return lastVisited.val;
            }
        }
        throw new IllegalStateException("No more elements");
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
