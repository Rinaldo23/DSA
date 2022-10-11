package BinaryTree.Level_1;

import java.util.*;

public class AllNodesKLevelFar {
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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();

        ArrayList<TreeNode> path = nodeToRootPath(root, target);
        for (int i = 0; i < path.size(); i++) {
            kLevelsDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1), ans);
        }

        return ans;
    }

    public ArrayList<TreeNode> nodeToRootPath_(TreeNode root, TreeNode data) {
        if (root == null)
            return null;

        if (root.val == data.val) {
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }

        ArrayList<TreeNode> left = nodeToRootPath_(root.left, data);
        if (left != null) {
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = nodeToRootPath_(root.right, data);
        if (right != null) {
            right.add(root);
            return right;
        }

        return null;
    }

    public ArrayList<TreeNode> nodeToRootPath(TreeNode root, TreeNode data) {
        ArrayList<TreeNode> result = nodeToRootPath_(root, data);
        return result != null ? result : new ArrayList<>();
    }

    public void kLevelsDown(TreeNode root, int k, TreeNode blockerNode, List<Integer> ans) {
        if (root == null || k < 0 || root == blockerNode)
            return;

        if (k == 0) {
            ans.add(root.val);
        }

        kLevelsDown(root.left, k - 1, blockerNode, ans);
        kLevelsDown(root.right, k - 1, blockerNode, ans);

    }
}
