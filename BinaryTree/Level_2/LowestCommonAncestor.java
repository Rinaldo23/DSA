package BinaryTree.Level_2;

public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor_(root, p, q);
        return LCA;
    }

    TreeNode LCA = null;

    public boolean lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        boolean self = (root.val == p.val || root.val == q.val);

        boolean left = lowestCommonAncestor_(root.left, p, q);
        if (LCA != null)
            return true;

        boolean right = lowestCommonAncestor_(root.right, p, q);
        if (LCA != null)
            return true;

        if ((left && right) || (left && self) || (right && self)) {
            LCA = root;
        }

        return (self || left || right);
    }
}
