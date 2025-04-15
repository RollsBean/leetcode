package algorithm.binaryTree.a_114_flatten;

import algorithm.binaryTree.TreeNode;

/**
 * 114. 二叉树展开为链表
 * <p><strong>先序遍历</strong>（中 左 右）展开
 */
class Solution {
    public void flatten(TreeNode root) {
        recursive(root);
    }

    /**
     * 返回右子树 tail，如果右子树为空，返回左子树 tail 节点，如果左右子树都为空，则返回当前节点
     * <br/>这样拉链时，我们就可以拉链成 root - root.left - root.left.tail - root.right
     * @param root
     * @return
     */
    private TreeNode recursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTail = recursive(root.left);
        TreeNode rightTail = recursive(root.right);

        TreeNode tail;
        if (rightTail != null) {
            tail = rightTail;
        } else if (leftTail != null) {
            tail = leftTail;
        } else {
            tail = root;
        }

        TreeNode left = root.left;
        root.left = null;
        if (leftTail != null) {
            TreeNode right = root.right;
            root.right = left;
            if (rightTail != null) {
                leftTail.right = right;
            }
        }

        return tail;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);

        solution.flatten(root);
        System.out.println(root);
    }
}
