package algorithm.binaryTree.a_101_isSymmetric;

import algorithm.binaryTree.TreeNode;

/**
 * 101. 对称二叉树
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return recursive(root.left, root.right);
    }

    private boolean recursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null || left == null && right != null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        boolean isLeftSymmetric = recursive(left.left, right.right);
        if (isLeftSymmetric) {
            return recursive(left.right, right.left);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        Solution solution = new Solution();
        boolean symmetric = solution.isSymmetric(root);
        System.out.println(symmetric);
    }
}
