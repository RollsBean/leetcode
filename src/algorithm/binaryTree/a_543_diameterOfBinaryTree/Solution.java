package algorithm.binaryTree.a_543_diameterOfBinaryTree;

import algorithm.binaryTree.TreeNode;

/**
 * 543. 二叉树的直径
 */
class Solution {

    private int maxPath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        recursive(root);
        return maxPath;
    }

    private int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = recursive(root.left);
        int rightDepth = recursive(root.right);
        // curPath 是以当前的 root 为根，path 的直径
        int curPath = leftDepth + rightDepth;
        maxPath = Math.max(maxPath, curPath);
        // 递归后再返回 +1，说明 depth 未包含当前节点，也可以当作是 depth 从 0 开始
        return Math.max(leftDepth, rightDepth) + 1;
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
        int i = solution.diameterOfBinaryTree(root);
        System.out.println(i);
    }
}
