package LeetCode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public void travel(List<List<Integer>> result, TreeNode root) {
        if (root == null) return;
        List<Integer> nodes = new ArrayList<>();
        if (root.left != null) nodes.add(root.left.val);
        if (root.right != null) nodes.add(root.right.val);
        if (!nodes.isEmpty()) result.add(nodes);
        travel(result, root.left);
        travel(result, root.right);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> nodes = new ArrayList<>();
        nodes.add(root.val);
        result.add(nodes);
        travel(result, root);
        return result;
    }
}
