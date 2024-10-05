package Tree;

public class MyBinarySearchTree {
    public TreeNode mRoot;

    public MyBinarySearchTree() {
    }

    public TreeNode insert(TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);
        // root == null
        if (root == null) {
            root = newNode;
            return root;
        }
        TreeNode temp = root;
        while (true) {
            if (value > temp.val) {
                if (temp.right == null) {
                    temp.right = newNode;
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                if (temp.left == null) {
                    temp.left = newNode;
                    break;
                } else {
                    temp = temp.left;
                }
            }
        }


        return root;
    }

    public TreeNode insertRecursion(TreeNode root, int value) {
        // root == null
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.val) {
            root.left = insertRecursion(root.left, value);
        } else {
            root.right = insertRecursion(root.right, value);
        }

        return root;
    }

    public TreeNode findLeftModeNode(TreeNode root) {
        if (root == null) return null;
        while (root.left != null) {
            root.left = root;
        }
        return root;
    }

    public TreeNode remove(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = remove(root.left, key);
        } else if (key > root.val) {
            root.right = remove(root.right, key);
        } else {
            // case root is leaf
            if (root.left == null && root.right == null) {
                return null;
            }
            // case root has only left child
            if (root.left != null && root.right == null) {
                return root.left;
            }
            // case root has only right child
            if (root.left == null && root.right != null) {
                return root.right;
            }
            // case root has two child
            TreeNode leftModeNode = findLeftModeNode(root.right);
            root.val = leftModeNode.val;
            root.right = remove(root.right, leftModeNode.val);
        }
        return root;
    }

    // node - left - right
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // left - node - right
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // left - right - node
    public static void postOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        inOrder(root.right);
        System.out.print(root.val + " ");
    }
}
