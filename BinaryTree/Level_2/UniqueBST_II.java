package BinaryTree.Level_2;

import java.util.*;

public class UniqueBST_II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees_(1, n);
    }

    public List<TreeNode> generateTrees_(int start, int end) {

        if (start > end) {
            List<TreeNode> ans = new ArrayList<>();
            ans.add(null);
            return ans;
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees_(start, i - 1);
            List<TreeNode> right = generateTrees_(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {

                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
