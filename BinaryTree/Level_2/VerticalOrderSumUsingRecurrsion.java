package BinaryTree.Level_2;

import java.util.*;

public class VerticalOrderSumUsingRecurrsion {
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

    private void widthOfBT(TreeNode root, int hl, int[] ans) {
        if (root == null)
            return;

        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);

        widthOfBT(root.left, hl - 1, ans);
        widthOfBT(root.right, hl + 1, ans);
    }

    public void dfs(TreeNode root, int hl, ArrayList<Integer> ans) {
        if (root == null)
            return;

        ans.set(hl,ans.get(hl)+root.val);

        dfs(root.left, hl - 1, ans);
        dfs(root.right, hl + 1, ans);
    }

    public ArrayList<Integer> verticalOrderSum(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        int[] minMax = new int[2];
        widthOfBT(root, 0, minMax);
        int width = minMax[1] - minMax[0] + 1;

        for (int i = 0; i < width; i++)
            ans.add(0);

        dfs(root,Math.abs(minMax[0]),ans);

        return ans;
    }
}
