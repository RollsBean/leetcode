package algorithm.binaryTree.a_102_levelOrder;

import algorithm.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 102. 二叉树的层序遍历
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelNode =  new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    levelNode.add(treeNode.val);

                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                result.add(levelNode);
            }
        }
        return result;
    }

}
