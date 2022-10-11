package BinaryTree.Level_2;

import java.util.ArrayList;

public class MorrisTraversal_PreOrder {
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

    public ArrayList<Integer> Solution(TreeNode node){
        ArrayList<Integer> ans = new ArrayList<>();

        TreeNode curr = node;

        while(curr != null){
            TreeNode leftNode = curr.left;

            if(leftNode == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode rightMostNode = getRightMostNode(leftNode, curr);

                if(rightMostNode.right == null){
                    rightMostNode.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                }else{
                    rightMostNode.right = null;
                    curr = curr.right;
                }
            }
        }


        return ans;
    }

    private TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr) {

        while(leftNode.right != null && leftNode.right != curr){
            leftNode = leftNode.right;
        }
        return leftNode;
    }
}
