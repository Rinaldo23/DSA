package BinaryTree.Level_2;

import java.util.*;

public class VerticalOrderOfBTwithoutUsingHashMap {
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

    public class vPair {
        TreeNode node;
        int hl;

        vPair(TreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    private void widthOfShadowBT(TreeNode root, int hl, int[] ans) {
        if (root == null)
            return;

        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);

        widthOfShadowBT(root.left, hl - 1, ans);
        widthOfShadowBT(root.right, hl + 1, ans);
    }

    public ArrayList<ArrayList<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        int[] minMax = new int[2];
        widthOfShadowBT(root, 0, minMax);
        int width = minMax[1] - minMax[0] + 1;

        for (int i = 0; i < width; i++) {
            ans.add(new ArrayList<>());
        }

        Queue<vPair> mq = new ArrayDeque<>();
        mq.add(new vPair(root, Math.abs(minMax[0])));

        while (mq.size() > 0) {
            int qSize = mq.size();

            while (qSize-- > 0) {
                vPair rp = mq.remove();

                int hl = rp.hl;
                TreeNode node = rp.node;

                ans.get(hl).add(node.val);

                if (rp.node.left != null) {
                    mq.add(new vPair(rp.node.left, rp.hl - 1));
                }

                if (rp.node.right != null) {
                    mq.add(new vPair(rp.node.right, rp.hl + 1));
                }
            }
        }
        return ans;
    }
}
