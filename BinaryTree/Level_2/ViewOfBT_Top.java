package BinaryTree.Level_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ViewOfBT_Top {
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

    public void widthBT(TreeNode root, int hl, int[] ans) {
        if (root == null)
            return;

        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);

        widthBT(root.left, hl - 1, ans);
        widthBT(root.right, hl + 1, ans);
    }

    public ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        int[] minMax = new int[2];
        widthBT(root, 0, minMax);

        int width = minMax[1] - minMax[0] + 1;

        for (int i = 0; i < width; i++) {
            ans.add(null);
        }

        Queue<vPair> mq = new ArrayDeque<>();
        mq.add(new vPair(root, Math.abs(minMax[0])));

        while (mq.size() != 0) {
            int qsize = mq.size();

            while (qsize-- > 0) {
                vPair rp = mq.remove();

                TreeNode node = rp.node;
                int hl = rp.hl;

                if(ans.get(hl)== null){
                    ans.set(hl, node.val);
                }

                if (node.left != null) {
                    mq.add(new vPair(node.left, hl - 1));
                }

                if (node.right != null) {
                    mq.add(new vPair(node.right, hl + 1));
                }
            }
        }

        return ans;
    }
}