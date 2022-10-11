package BinaryTree.Level_2;

public class isBST_InOrder_UsingRecurrsion {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        if (!isValidBST(root.left))
            return false;

        if (prev != null && prev.val > root.val)
            return false;

        prev = root;

        if (!isValidBST(root.right))
            return false;

        return true;
    }

    // LeetCode
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, null, null);
    }

    public boolean isValidBST2(TreeNode root, TreeNode left, TreeNode right) {

        if (root == null)
            return true;

        if (left != null && left.val >= root.val)
            return false;

        if (right != null && right.val <= root.val)
            return false;

        boolean ans = isValidBST2(root.left, left, root) && isValidBST2(root.right, root, right);
        return ans;
    }
}
