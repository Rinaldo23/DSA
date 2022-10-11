package BinaryTree.Level_2;

public class RecoverBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void recoverTree(TreeNode root) {
        TreeNode curr = root, prev = null, a = null, b = null;

        while (curr != null) {
            TreeNode leftNode = curr.left;
            
            if (leftNode == null) {
                if(prev != null && prev.val > curr.val){
                    if(a == null){
                        a = prev;
                    }
                    b = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode farthestRightNode = getFarthestRightNode(leftNode, curr);

                if(farthestRightNode.right == null){
                    farthestRightNode.right = curr;
                    curr = curr.left;
                }else{
                    farthestRightNode.right = null;
                    if(prev != null && prev.val > curr.val){
                        if(a == null){
                            a = prev;
                        }
                        b = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        //Swap Logic
        if(a != null){
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }

    private TreeNode getFarthestRightNode(TreeNode leftNode, TreeNode curr) {

        while(leftNode.right != null && leftNode.right != curr){
            leftNode = leftNode.right;
        }
        return leftNode;
    }
}
