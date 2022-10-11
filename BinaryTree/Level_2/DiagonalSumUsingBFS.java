package BinaryTree.Level_2;

import java.util.*;

public class DiagonalSumUsingBFS {
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

    public ArrayList<Integer> diagonalSum(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<TreeNode> mq = new ArrayDeque<>();
        mq.add(root);

        while (mq.size() > 0) {
            int qsize = mq.size();

            int sum = 0;
            while (qsize-- > 0) {
                TreeNode rn = mq.remove();

                while (rn != null) {
                    sum += rn.val;
                    if (rn.left != null) {
                        mq.add(rn.left);
                    }
                    rn = rn.right;
                }
            }
            ans.add(sum);
        }
        return ans;
    }
}
