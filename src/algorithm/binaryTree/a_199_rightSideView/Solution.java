package algorithm.binaryTree.a_199_rightSideView;

import algorithm.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * <p/>层序遍历即可
 */
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.poll();
                if (i == 0) {
                    result.add(treeNode.val);
                }
                if (treeNode.right != null) {
                    deque.offer(treeNode.right);
                }
                if (treeNode.left != null) {
                    deque.offer(treeNode.left);
                }
            }
        }
        return result;
    }
}
