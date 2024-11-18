package LeetCode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    private void travel(TreeNode root, String currentPath, List<String> result) {
        if (root == null) return;
        if (!currentPath.isEmpty()) {
            currentPath += "->";
        }
        currentPath += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            result.add(currentPath);
            return;
        }
        travel(root.left, currentPath, result);
        travel(root.right, currentPath, result);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        travel(root, "", result);
        return result;
    }
}
