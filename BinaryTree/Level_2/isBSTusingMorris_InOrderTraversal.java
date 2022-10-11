package BinaryTree.Level_2;

public class isBSTusingMorris_InOrderTraversal {

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

    public boolean isValidBST(TreeNode root) {

        TreeNode prev = null;
        TreeNode curr = root;
        while(curr != null){
            TreeNode leftNode = curr.left;

            if(leftNode == null){
                if(prev != null && prev.val > curr.val){
                    return false;
                }
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode rightMostNode = getRightMostNode(leftNode, curr);

                if(rightMostNode.right == null){
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else{
                    if(prev.val > curr.val){
                        return false;
                    }
                    prev = curr;
                    rightMostNode.right = null;
                    curr = curr.right;
                }
            }
        }

        return true;
        
    }

    private TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr) {

        while(leftNode.right != null && leftNode.right != curr){
            leftNode = leftNode.right;
        }
        return leftNode;
    }
}
