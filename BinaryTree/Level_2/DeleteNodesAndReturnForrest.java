package BinaryTree.Level_2;

import java.util.*;

public class DeleteNodesAndReturnForrest extends MAIN {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : to_delete){
            set.add(ele);
        }
        
        List<TreeNode> ans = new ArrayList<>();
        delNodes_(root, set, ans);
        if(!set.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }
    
    public TreeNode delNodes_(TreeNode root, HashSet<Integer> set, List<TreeNode> ans) {
        if(root == null) return null;
        
        root.left = delNodes_(root.left, set, ans);
        root.right = delNodes_(root.right, set, ans);
        
        if(set.contains(root.val)){
            if(root.left != null){
                ans.add(root.left);
            }
            if(root.right != null){
                ans.add(root.right);
            }
            
            return null;
        }
        
        return root;
    }
}
