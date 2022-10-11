package BinaryTree.Level_2;

public class CountGoodNodes extends MAIN {

    // METHOD - 1 FASTER
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return goodNodes_(root, Integer.MIN_VALUE);
    }

    public int goodNodes_(TreeNode root, int max) {

        if (root == null)
            return 0;

        int ans = 0;
        if (root.val >= max)
            ans = 1;
        max = Math.max(max, root.val);

        int lCount = goodNodes_(root.left, max);
        int rCount = goodNodes_(root.right, max);

        return lCount + rCount + ans;
    }

// -------------------------------------------------------------------------------------------------------------------------------------------------------

    // METHOD - 2
    public int goodNodes2(TreeNode root) {
        if (root == null)
            return 0;
        int[] count = new int[1];
        goodNodes2_(root, Integer.MIN_VALUE, count);
        return count[0];
    }

    public void goodNodes2_(TreeNode root, int max, int[] count) {

        if (root == null)
            return;

        if (root.val >= max) {
            count[0] = count[0] + 1;
            max = Math.max(max, root.val);
        }

        goodNodes2_(root.left, max, count);
        goodNodes2_(root.right, max, count);
    }
}
