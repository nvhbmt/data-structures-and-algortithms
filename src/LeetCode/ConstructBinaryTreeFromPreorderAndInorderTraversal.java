package LeetCode;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preorderIndex;
    private Map<Integer, Integer> inorderMapIndex;

    private TreeNode buildTree(int[] preorder, int startInorder, int endInorder) {
        if (startInorder > endInorder) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int midInInorder = inorderMapIndex.get(rootVal);

        root.left = buildTree(preorder, startInorder, midInInorder - 1);
        root.right = buildTree(preorder, midInInorder + 1, endInorder);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMapIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMapIndex.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);
    }

}
