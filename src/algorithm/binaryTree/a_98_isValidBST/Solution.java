package algorithm.binaryTree.a_98_isValidBST;

import algorithm.binaryTree.TreeNode;

/**
 * 98. 验证二叉搜索树
 * <p/> 二叉搜索树，左子树小于根节点，右子树大于根节点，并且所有左子树和右子树都是二叉搜索树
 */
class Solution {

    /**
     * Integer 的范围是 -2<sup>31</sup> ~ 2<sup>31-1</sup>，val 的值在这个范围内，可能正好等于 -2<sup>31</sup>，所以要用 long 类型
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        // 用 Long 类型
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        boolean leftValid = isValidBST(root.left, min, root.val);
        boolean rightValid = isValidBST(root.right, root.val, max);
        return leftValid && rightValid;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(6);

        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        Solution solution = new Solution();
        boolean validBST = solution.isValidBST(root);
        System.out.println(validBST);
    }
}
