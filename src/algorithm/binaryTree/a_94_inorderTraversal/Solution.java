package algorithm.binaryTree.a_94_inorderTraversal;

import algorithm.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }

    void recursive(TreeNode root, List<Integer> result) {
        // 1.终止条件
        if (root == null) {
            return;
        }

        // 2. 递归并收集结果
        recursive(root.left, result);
        result.add(root.val);
        recursive(root.right, result);
    }
}
