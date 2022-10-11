package BinaryTree.Level_2;

public class MaximumPathBetweenTwoLeafNodes_HeapMoverMethod {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int maxPathSum(Node root)
    { 
        int[] LTLMaxSum = new int[1];
        LTLMaxSum[0] = Integer.MIN_VALUE;
        int rres = NodeToLeafMaxPath(root, LTLMaxSum);
        
        if(root.left == null || root.right == null) return Math.max(LTLMaxSum[0],rres);  // IMP 
        
        return LTLMaxSum[0];
    } 
    
    int NodeToLeafMaxPath(Node root, int[] LTLMaxSum)
    { 
        if(root == null) return Integer.MIN_VALUE;
        
        if(root.left == null && root.right == null){
            return root.data;
        }
        
        int left = NodeToLeafMaxPath(root.left, LTLMaxSum);
        int right = NodeToLeafMaxPath(root.right, LTLMaxSum);
        
        if(root.left != null && root.right != null){
            LTLMaxSum[0] = Math.max(LTLMaxSum[0], left + right + root.data);
        }
        
        return Math.max(left, right) + root.data;
    }
}
