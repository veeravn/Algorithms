package com.vnaidu;

import java.util.Optional;

public class BinaryTreeTilt extends Base {

    int count = 0;

    public int findTilt(BTNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int lc = findTilt(root.left);
        int rc = findTilt(root.right);
        if(root.left != null){
            left = root.left.data;
        }
        if(root.right != null){
            right = root.right.data;
        }

        count += Math.abs(left - right);
        return lc+rc+count;
    }
    public static void main(String[] args) {
        BinaryTreeTilt tilt = new BinaryTreeTilt();
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.right.left = new BTNode(5);

        logger.info(tilt.findTilt(root) + "");
    }
}
