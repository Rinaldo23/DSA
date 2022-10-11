package BinaryTree.Level_2;

public class MaximumPathBetweenAnyNodeOfBinaryTree {
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

    public int maxPathSum(TreeNode root) {
        return maxPathSum_(root).NTN_MaxSum;
    }

    public pair maxPathSum_(TreeNode root) {
        if (root == null)
            return new pair();

        pair lp = maxPathSum_(root.left);
        pair rp = maxPathSum_(root.right);

        pair mp = new pair();

        mp.RTN_MaxSum = Math.max(Math.max(lp.RTN_MaxSum, rp.RTN_MaxSum) + root.val, root.val);

        mp.NTN_MaxSum = getMaxSum(lp.NTN_MaxSum, rp.NTN_MaxSum, lp.RTN_MaxSum + rp.RTN_MaxSum + root.val, root.val,
                mp.RTN_MaxSum);

        // mp.RTN_MaxSum = Math.max(mp.RTN_MaxSum, root.val); ---->> Important check line no 36

        return mp;
    }

    public int getMaxSum(int... arr) {
        int max = arr[0];
        for (int ele : arr) {
            max = Math.max(max, ele);
        }
        return max;
    }

    public class pair {
        int NTN_MaxSum = Integer.MIN_VALUE;
        int RTN_MaxSum = 0;
    }
}
