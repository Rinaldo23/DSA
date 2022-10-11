package BinaryTree.Level_2;

public class ConstructBT_From_In_PreOrderTraversal {
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

    public TreeNode buildTree_(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (isi > iei) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[psi]);

        int idx = isi;
        while (inorder[idx] != preorder[psi]) {
            idx++;
        }
        int colst = idx - isi;

        node.left = buildTree_(preorder, psi + 1, psi + colst, inorder, isi, idx - 1);
        node.right = buildTree_(preorder, psi + colst + 1, pei, inorder, idx + 1, iei);

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        return buildTree_(preorder, 0, n - 1, inorder, 0, n - 1);
    }
}