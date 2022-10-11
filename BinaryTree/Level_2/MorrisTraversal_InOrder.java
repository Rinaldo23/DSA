package BinaryTree.Level_2;

import java.util.ArrayList;

public class MorrisTraversal_InOrder {
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

    public ArrayList<Integer> Solution(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();

        TreeNode curr = node;

        while (curr != null) {
            TreeNode leftNode = curr.left;
            
            if (leftNode == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode farthestRightNode = getFarthestRightNode(leftNode, curr);

                if(farthestRightNode.right == null){
                    farthestRightNode.right = curr;
                    curr = curr.left;
                }else{
                    farthestRightNode.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    private TreeNode getFarthestRightNode(TreeNode leftNode, TreeNode curr) {

        while(leftNode.right != null && leftNode.right != curr){
            leftNode = leftNode.right;
        }
        return leftNode;
    }
}
