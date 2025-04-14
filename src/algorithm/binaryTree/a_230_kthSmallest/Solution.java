package algorithm.binaryTree.a_230_kthSmallest;

import algorithm.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        recursive(root, list, k);
        return list.get(k - 1);
    }

    private void recursive(TreeNode root, List<Integer> list, int k) {
        if (root == null || list.size() == k) {
            return;
        }
        recursive(root.left, list, k);
        list.add(root.val);
        recursive(root.right, list, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        Solution solution = new Solution();
        int i = solution.kthSmallest(root, 3);
        System.out.println(i);
    }
}
