package LeetCode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    private void rightSideView(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(root.val);
        }
        rightSideView(root.right, list, level + 1);
        rightSideView(root.left, list, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }
}
