package LeetCode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> list = new ArrayList<>();

    private void dfs(TreeNode root, int height) {
        if (root == null) return;

        if (height == list.size()) list.add(new ArrayList<>());

        List<Integer> array = list.get(height);
        array.add(root.val);
        list.set(height, array);

        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return list;
        dfs(root, 0);
        return list;
    }
}
