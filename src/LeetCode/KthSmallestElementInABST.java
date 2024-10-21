package LeetCode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {
    private void inOrderTravel(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrderTravel(root.left, list);
        list.add(root.val);
        inOrderTravel(root.right, list);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTravel(root, list);
        return list.get(k - 1);
    }
}
