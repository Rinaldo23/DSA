package BinaryTree.Level_2;

import java.util.*;

public class PathSum_2 {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        pathSum_(root, targetSum, res, temp);
        return res;
    }

    public void pathSum_(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> temp) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                List<Integer> base = new ArrayList<>(temp);  // Creating a Deep copy of temp AL
                base.add(root.val);
                res.add(base);
            }
            return;
        }

        temp.add(root.val);

        pathSum_(root.left, targetSum - root.val, res, temp);
        pathSum_(root.right, targetSum - root.val, res, temp);

        temp.remove(temp.size() - 1);

    }
}
