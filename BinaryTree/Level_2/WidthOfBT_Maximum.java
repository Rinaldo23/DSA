package BinaryTree.Level_2;

import java.util.*;

// Max width on each level
public class WidthOfBT_Maximum {
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

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(root, 0));
        
        int max = 0;
        
        while(mq.size() > 0){
            int size = mq.size();
            int leftIdx = mq.peek().idx;
            int rightIdx = mq.peek().idx;
            
            while(size-->0){
                Pair rp = mq.remove();
                TreeNode rn = rp.node;
                int rIdx = rp.idx;
                
                rightIdx = rIdx;
                
                if(rn.left != null){
                    mq.add(new Pair(rn.left, 2*rIdx + 1));
                }
                
                if(rn.right != null){
                    mq.add(new Pair(rn.right, 2*rIdx + 2));
                }
            }
            
            max = Math.max(max, rightIdx - leftIdx + 1);
        }
        
        return max;
    }
    
    public class Pair{
        TreeNode node;
        int idx;
        
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
}
