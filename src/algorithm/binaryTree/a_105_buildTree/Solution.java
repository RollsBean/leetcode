package algorithm.binaryTree.a_105_buildTree;

import algorithm.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序遍历和中序遍历数组中构造二叉树
 * <p>前序遍历：根节点，[左子树]，[右子树]；中序遍历：[左子树]，根节点，[右子树]
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        Map<Integer, Integer> preorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        for (int i = 0; i < preorder.length; i++) {
            preorderMap.put(preorder[i], i);
        }
        return partition(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, inorderMap, preorderMap);
    }

    private TreeNode partition(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inorderMap,  Map<Integer, Integer> preorderMap) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        // 中序：左子树、根、右子树
        Integer inorderRootIdx = inorderMap.get(val);
        // 前序：根、左子树、右子树
        int leftLength = inorderRootIdx - inStart;
        TreeNode left = partition(inorder, inStart, inorderRootIdx - 1, preorder, preStart + 1, preStart + leftLength, inorderMap, preorderMap);
        TreeNode right = partition(inorder, inorderRootIdx+1, inEnd, preorder, preStart + leftLength + 1 , preEnd, inorderMap, preorderMap);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
    }
}
