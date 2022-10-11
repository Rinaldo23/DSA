package BinaryTree.Level_2;

import java.util.*;

public class AllPossibleFullBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        return allPossibleFBT_(n);
    }

    public List<TreeNode> allPossibleFBT_(int n) {

        if (n == 1) {
            List<TreeNode> ans = new ArrayList<>();
            ans.add(new TreeNode(0));
            return ans;
        }

        List<TreeNode> ans = new ArrayList<>();

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT_(i);
            List<TreeNode> right = allPossibleFBT_(n - i - 1);

            for (TreeNode l : left) {
                for (TreeNode r : right) {

                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);

                }
            }
        }
        return ans;
    }
}
