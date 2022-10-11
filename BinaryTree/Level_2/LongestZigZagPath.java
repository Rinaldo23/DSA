package BinaryTree.Level_2;

public class LongestZigZagPath {
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

    public class Pair {
        int forwardSlope = -1;
        int backwardSlope = -1;
        int maxLen = 0;
    }

    public Pair longestZigZag_(TreeNode root){
        if(root == null) return new Pair();

        Pair lchild = longestZigZag_(root.left);
        Pair rchild = longestZigZag_(root.right);

        Pair mp = new Pair();
        int ans1 = Math.max(lchild.backwardSlope, rchild.forwardSlope) + 1; //root length
        int ans2 = Math.max(lchild.maxLen, rchild.maxLen);
        mp.maxLen = Math.max(ans1,ans2);

        mp.forwardSlope = lchild.backwardSlope + 1;
        mp.backwardSlope = rchild.forwardSlope + 1;

        return mp;
    }

    public int longestZigZag(TreeNode root) {
        Pair ans = longestZigZag_(root);
        return ans.maxLen;
    }
}
