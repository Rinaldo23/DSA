package BinaryTree.Level_2;

public class ConstructBT_From_In_PostOrderTraversal {
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

    public TreeNode buildTree_(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (isi > iei) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[pei]);

        int idx = isi;
        while (inorder[idx] != postorder[pei]) {
            idx++;
        }
        int colst = idx - isi;

        node.left = buildTree_(postorder, psi, psi + colst - 1, inorder, isi, idx - 1);
        node.right = buildTree_(postorder, psi + colst, pei - 1, inorder, idx + 1, iei);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;

        return buildTree_(postorder, 0, n - 1, inorder, 0, n - 1);
    }
}