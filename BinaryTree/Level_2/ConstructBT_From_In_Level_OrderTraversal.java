package BinaryTree.Level_2;

import java.util.HashSet;

public class ConstructBT_From_In_Level_OrderTraversal {
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

    public TreeNode buildTree_(int[] inorder, int isi, int iei, int[] levelorder) {

        TreeNode root = new TreeNode(levelorder[0]);
        // if(isi == iei) return root;
        if (levelorder.length == 1)
            return root;

        int idx = isi;
        while (inorder[idx] != root.val) {
            idx++;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = isi; i < idx; i++) {
            set.add(inorder[i]);
        }

        int[] leftSubTree = new int[idx - isi];
        int[] rightSubTree = new int[iei - idx];
        int ls = 0, rs = 0;

        for (int i = 1; i < levelorder.length; i++) {
            int ele = levelorder[i];
            if (set.contains(ele)) {
                leftSubTree[ls++] = ele;
                set.remove(ele);
            } else {
                rightSubTree[rs++] = ele;
            }
        }

        root.left = buildTree_(inorder, isi, idx - 1, leftSubTree);
        root.right = buildTree_(inorder, idx + 1, iei, rightSubTree);

        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] levelorder) {
        int n = inorder.length;
        return buildTree_(inorder, 0, n - 1, levelorder);

    }
}