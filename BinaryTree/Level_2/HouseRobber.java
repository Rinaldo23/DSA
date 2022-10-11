package BinaryTree.Level_2;

public class HouseRobber {
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

    public class HousePair {
        int withrobbery;
        int withOutRobbery;
    }

    public HousePair robbery(TreeNode root) {
        if (root == null) {
            return new HousePair();
        }

        HousePair lchild = robbery(root.left);
        HousePair rchild = robbery(root.right);

        HousePair mp = new HousePair();
        mp.withrobbery = root.val + lchild.withOutRobbery + rchild.withOutRobbery;
        mp.withOutRobbery = Math.max(lchild.withrobbery, lchild.withOutRobbery)
                + Math.max(rchild.withrobbery, rchild.withOutRobbery);

        return mp;
    }

    public int rob(TreeNode root) {
        HousePair ans = robbery(root);
        int result = Math.max(ans.withrobbery, ans.withOutRobbery);
        return result;
    }
}
