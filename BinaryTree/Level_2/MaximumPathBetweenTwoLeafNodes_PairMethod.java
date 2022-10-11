package BinaryTree.Level_2;

public class MaximumPathBetweenTwoLeafNodes_PairMethod {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int maxPathSum(Node root) {
        Pair ans = maxPathSum_(root);
        return ans.LTLMaxSum;
    }

    Pair maxPathSum_(Node root) {
        if (root == null)
            return new Pair();

        if (root.left == null && root.right == null) {
            Pair bp = new Pair();
            bp.NTLMaxSum = root.data;
            return bp;
        }

        Pair left = maxPathSum_(root.left);
        Pair right = maxPathSum_(root.right);

        Pair mp = new Pair();

        mp.LTLMaxSum = Math.max(left.LTLMaxSum, right.LTLMaxSum);

        if (root.left != null && root.right != null) {
            mp.LTLMaxSum = Math.max(mp.LTLMaxSum, left.NTLMaxSum + right.NTLMaxSum + root.data);
        }

        mp.NTLMaxSum = Math.max(left.NTLMaxSum, right.NTLMaxSum) + root.data;

        return mp;
    }

    class Pair {
        int LTLMaxSum = Integer.MIN_VALUE;
        int NTLMaxSum = Integer.MIN_VALUE;
    }
}
