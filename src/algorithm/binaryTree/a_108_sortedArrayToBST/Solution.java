package algorithm.binaryTree.a_108_sortedArrayToBST;

import algorithm.binaryTree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generateTree(nums, 0, nums.length - 1);
    }

    private TreeNode generateTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generateTree(nums, start, mid - 1);
        root.right = generateTree(nums, mid + 1, end);
        return root;
    }
}
