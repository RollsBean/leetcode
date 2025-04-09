package algorithm.binaryTree.a_226_invertTree;

import algorithm.binaryTree.TreeNode;

/**
 * @author 景行
 * @date 2021/05/30
 **/
public class Solution {

    /**
     * 翻转二叉树
     * <br/>
     * 递归依次反转
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null)
            return root;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
