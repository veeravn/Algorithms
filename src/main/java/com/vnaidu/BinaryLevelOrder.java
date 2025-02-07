package com.vnaidu;

import java.util.ArrayList;
import java.util.List;

import com.vnaidu.FlattenBinaryTree.TreeNode;

public class BinaryLevelOrder extends Base {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        levelOrder(ans, root, 0);
        return ans;
    }

    private void levelOrder(List<List<Integer>> ans, TreeNode root, int level) {
        if (root == null)
            return;
        if (level == ans.size()) {
            List<Integer> addNext = new ArrayList<>();
            ans.add(addNext);
        }

        ans.get(level).add(root.val);
        levelOrder(ans, root.left, level + 1);
        levelOrder(ans, root.right, level + 1);
    }
}
