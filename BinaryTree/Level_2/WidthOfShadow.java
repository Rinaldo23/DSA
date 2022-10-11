package BinaryTree.Level_2;

public class WidthOfShadow {
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

    public int widthOfShadowBT(TreeNode root){
        int[] ans = new int[2];
        widthOfShadowBT_(root,0,ans);

        return ans[1] - ans[0] + 1;
    }

    private void widthOfShadowBT_(TreeNode root, int hl, int[] ans) {
        if(root == null) return;

        ans[0] = Math.min(ans[0],hl);
        ans[1] = Math.max(ans[1], hl);

        widthOfShadowBT_(root.left, hl - 1, ans);
        widthOfShadowBT_(root.right, hl + 1, ans);
    }
}
