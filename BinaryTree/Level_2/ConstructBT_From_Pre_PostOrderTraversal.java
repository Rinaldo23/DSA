package BinaryTree.Level_2;

public class ConstructBT_From_Pre_PostOrderTraversal {
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

    public TreeNode buildTree_(int[] preorder, int psi, int pei, int[] postorder, int posi, int poei) {   
        if (psi > pei) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[psi]);
        if(psi == pei) return node;  // If onlt one element/Node is present return that node -> IMP
        
        int idx = posi;
        while (postorder[idx] != preorder[psi + 1]) {
            idx++;
        }
        int colst = idx - posi + 1;

        node.left = buildTree_(preorder, psi + 1, psi + colst, postorder, posi, idx);
        node.right = buildTree_(preorder, psi + colst + 1, pei, postorder, idx + 1, poei - 1);

        return node;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return buildTree_(preorder, 0, n - 1, postorder, 0, n - 1);
    }
}