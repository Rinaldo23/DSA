package BinaryTree.Level_2;

import java.util.*;

public class VerticalOrderOfBTusingHashMap {
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

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        Queue<vPair> mq = new ArrayDeque<>();
        mq.add(new vPair(root, 0));
        int minhl = 0, maxhl = 0;

        while (mq.size() > 0) {
            int qSize = mq.size();

            while (qSize-- > 0) {
                vPair rp = mq.remove();

                map.putIfAbsent(rp.hl, new ArrayList<>());
                ArrayList<Integer> val = map.get(rp.hl);
                val.add(rp.node.val);

                minhl = Math.min(minhl, rp.hl);
                maxhl = Math.max(maxhl, rp.hl);

                if (rp.node.left != null) {
                    mq.add(new vPair(rp.node.left, rp.hl - 1));
                }

                if (rp.node.right != null) {
                    mq.add(new vPair(rp.node.right, rp.hl + 1));
                }
            }
        }

        for (int i = minhl ; i <= maxhl; i++) {
            ArrayList<Integer> val = map.get(i);
            ans.add(val);
        }

        return ans;

    }
}
