package BinaryTree.Level_2;

import java.util.*;

public class DiagonalSumUsingRecurssion_DFS {
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

    public void dfs(TreeNode root, int diagonalNo, ArrayList<Integer> ans) {

        if (root == null) return;

        if (diagonalNo == ans.size()) ans.add(0);
        ans.set(diagonalNo, ans.get(diagonalNo) + root.val);

        dfs(root.left, diagonalNo + 1, ans);
        dfs(root.right, diagonalNo, ans);
    }

    public ArrayList<Integer> diagonalSum(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);

        return ans;
    }
}
