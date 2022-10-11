package BinaryTree.Level_2;

import java.util.*;

public class ViewOfBT_Right {
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

    public List<Integer> RightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> mq = new ArrayDeque<>();
        mq.add(root);

        while (mq.size() > 0) {
            int qsize = mq.size();

            TreeNode node = mq.peek();
            ans.add(node.val);

            for (int i = 0; i < qsize; i++) {
                TreeNode rmn = mq.remove();

                if (rmn.right != null) {
                    mq.add(rmn.right);
                }

                if (rmn.left != null) {
                    mq.add(rmn.left);
                }
            }
        }
        return ans;
    }
}
