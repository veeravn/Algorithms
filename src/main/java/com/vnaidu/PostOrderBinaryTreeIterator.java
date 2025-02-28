package com.vnaidu;

public interface PostOrderBinaryTreeIterator {
    /** Returns the next integer in the post-order traversal of the given binary tree.
     * For example, given a binary tree below,
     *        4
     *       / \
     *     2    6
     *    / \   / \
     *   1  3   5  7
     * the outputs will be 1, 3, 2, 5, 7, 6, 4.
     */
    int next();

    /** Return true if traversal has not finished; otherwise, return false. */
    boolean hasNext();
}
