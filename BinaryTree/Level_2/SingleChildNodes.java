package BinaryTree.Level_2;

import java.util.ArrayList;

public class SingleChildNodes {
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

    public static void exactlyOneChild_(TreeNode root, ArrayList<Integer> ans) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.left == null || root.right == null) {
            ans.add(root.val);
        }

        exactlyOneChild_(root.left, ans);
        exactlyOneChild_(root.right, ans);
    }

    public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        exactlyOneChild_(root, ans);
        return ans;
    }
}
