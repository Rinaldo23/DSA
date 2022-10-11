package BinaryTree.Level_2;

import java.util.*;

public class CompleteBTInserter {

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

    class CBTInserter {
    
        TreeNode head = null;
        TreeNode pointer = null;
        
        Queue<TreeNode> mq = new ArrayDeque<>();
        
        public CBTInserter(TreeNode root) {
            head = root;
            mq.add(root);
            
            while(true){
                TreeNode node = mq.peek();
                
                if(node.left != null){
                    mq.add(node.left);
                }else{
                    pointer = node;
                    break;
                }
                    
                if(node.right != null){
                    mq.add(node.right);
                }else{
                    pointer = node;
                    break;
                }
                mq.remove();
            }
        }
        
        public int insert(int val) {
            int tVal = pointer.val;
            if(pointer.left == null){
                TreeNode node = new TreeNode(val);
                pointer.left = node;
                mq.add(node);
            }else{
                TreeNode node = new TreeNode(val);
                pointer.right = node;
                mq.add(node);
                mq.remove();
                pointer = mq.peek();
            }
            return tVal;
        }
        
        public TreeNode get_root() {
            return head;
        }
    }
}
