package LeetCode;

import Tree.TreeNode;

public class SumOfLeftLeaves {
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;

        if (root.left != null) {
            if (isLeaf(root.left)) sum += root.left.val;
            else sum += sumOfLeftLeaves(root.left);
        }

        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
