package BinaryTree.Level_2;

public class SingleChildNodes_Count {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

// -------------------------------------------------------------------------------------------------------------
    static int count = 0;
    public static int countExactlyOneChild_(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            count++;
        }

        countExactlyOneChild(root.left);
        countExactlyOneChild(root.right);

        return count;
    }

// ------------------------------------------------------------------------------------------------------------
    public static int countExactlyOneChild(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        int leftCount = countExactlyOneChild(root.left);
        int rightCount = countExactlyOneChild(root.right);

        int count = leftCount + rightCount;
        if (root.left == null || root.right == null)
            count++;

        return count;
    }
}
