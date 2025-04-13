package algorithm.binaryTree.a_104_maxDepth;

import algorithm.binaryTree.TreeNode;

class Solution {

    private int max = 0;

    public int maxDepth(TreeNode root) {
        recursive(root, 0);
        return max;
    }

    private void recursive(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        max = Math.max(depth + 1, max);
        recursive(root.left, depth + 1);
        recursive(root.right, depth + 1);
    }
}
