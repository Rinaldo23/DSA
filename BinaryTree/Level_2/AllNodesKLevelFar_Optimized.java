package BinaryTree.Level_2;

import java.util.*;

public class AllNodesKLevelFar_Optimized {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();

        nodeToRootPath(root, target, k, ans);

        return ans;
    }

    public int nodeToRootPath(TreeNode root, TreeNode data, int k, List<Integer> ans) {
        if (root == null)
            return -1;

        if (root.val == data.val) {
            kLevelsDown(root, k - 0, null, ans);
            return 1;
        }

        int left = nodeToRootPath(root.left, data, k, ans);
        if (left != -1) {
            kLevelsDown(root, k - left, root.left, ans);
            return left + 1;
        }

        int right = nodeToRootPath(root.right, data, k, ans);
        if (right != -1) {
            kLevelsDown(root, k - right, root.right, ans);
            return right + 1;
        }

        return -1;
    }

    public void kLevelsDown(TreeNode root, int k, TreeNode blockerNode,List<Integer> ans){
        if(root == null || k < 0 || root == blockerNode) return;
        
        if( k == 0){
            ans.add(root.val);
            return;
        }
        
        kLevelsDown(root.left, k - 1, blockerNode, ans);
        kLevelsDown(root.right, k - 1, blockerNode, ans);
        
    }
}
