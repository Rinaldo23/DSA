package BinaryTree.Level_2;

import java.util.*;

public class DiagonalTraversalReverse {
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

    public ArrayList<ArrayList<Integer>> diagonalTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> mq = new ArrayDeque<>();
        mq.add(root);

        while (mq.size() > 0) {
            int qsize = mq.size();
            ArrayList<Integer> smallAns = new ArrayList<>();

            while (qsize-- > 0) {
                TreeNode rn = mq.remove();

                while (rn != null) {
                    smallAns.add(rn.val);
                    if (rn.right != null) {
                        mq.add(rn.right);
                    }
                    rn = rn.left;
                }
            }
            ans.add(smallAns);
        }
        return ans;
    }
}
