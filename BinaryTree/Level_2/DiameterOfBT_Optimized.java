package BinaryTree.Level_2;

// O(N)
public class DiameterOfBT_Optimized {
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

    public int diameterOfBinaryTree(TreeNode root) {
        Pair ans = diameterOfBinaryTree_(root);
        return ans.dia;
    }
    
    public Pair diameterOfBinaryTree_(TreeNode root) {
        if(root == null){
            Pair bp = new Pair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }
        
        Pair left = diameterOfBinaryTree_(root.left);
        Pair right = diameterOfBinaryTree_(root.right);
        
        Pair mp = new Pair();
        mp.ht = Math.max(left.ht, right.ht) + 1;
        mp.dia = Math.max(Math.max(left.dia, right.dia), left.ht + right.ht + 2);
        
        return mp;
    }
    
    public class Pair {
        int dia;
        int ht;
    }
}