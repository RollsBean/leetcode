package algorithm.binaryTree.a_102_levelOrder;

import algorithm.binaryTree.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offerLast(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelNode =  new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.pollFirst();
                    levelNode.add(treeNode.val);

                    if (treeNode.left != null) {
                        queue.offerLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offerLast(treeNode.right);
                    }
                }
                result.add(levelNode);
            }
        }
        return result;
    }

}
