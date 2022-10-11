package BinaryTree.Level_2;

public class isBSTusingPairClass {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair {
        boolean isBST;
        int min;
        int max;
    }

    public Pair isValidBST_(TreeNode root) {
        if (root == null) {
            Pair bp = new Pair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            return bp;
        }

        Pair lchild = isValidBST_(root.left);
        Pair rchild = isValidBST_(root.right);

        Pair mp = new Pair();

        mp.isBST = lchild.isBST && rchild.isBST && (root.val >= lchild.max && root.val <= rchild.min);
        mp.min = Math.min(root.val, Math.min(lchild.min, rchild.min));
        mp.max = Math.max(root.val, Math.max(lchild.max, rchild.max));

        return mp;
    }

    public boolean isValidBST(TreeNode root) {
        Pair ans = isValidBST_(root);
        return ans.isBST;
    }
}
