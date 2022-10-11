package BinaryTree.Level_2;

// O(N*N)
public class DiameterOfBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        int myDia = height(root.left) + height(root.right) + 2;

        return Math.max(Math.max(leftDia, rightDia), myDia);
    }

    public int height(TreeNode root) {
        if (root == null)
            return -1;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}