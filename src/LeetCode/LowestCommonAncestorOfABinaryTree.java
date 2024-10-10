package LeetCode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {
    private TreeNode resultTreeNode;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        if (root.val == p.val || root.val == q.val) {
            if (left || right) resultTreeNode = root;
            return true;
        }

        if (left && right) {
            resultTreeNode = root;
            return true;
        }

        return left || right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return resultTreeNode;
    }

    private boolean findPath(TreeNode root, List<TreeNode> path, TreeNode x) {
        if (root == null) return false;
        path.add(root);
        if (root.val == x.val) return true;
        if (findPath(root.left, path, x) || findPath(root.right, path, x)) {
            return true;
        }
        path.removeLast();
        return false;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        findPath(root, pathP, p);
        findPath(root, pathQ, q);
        int i = 0;
        for (i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathQ.get(i).val == pathP.get(i).val) break;
        }
        return pathP.get(i - 1);
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
