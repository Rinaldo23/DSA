package BinaryTree.Level_2;

import java.util.*;

public class ViewOfBT_Left {
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

    public List<Integer> leftSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> mq = new ArrayDeque<>();
        mq.add(root);

        while (mq.size() > 0) {
            int qsize = mq.size();

            TreeNode node = mq.peek();
            ans.add(node.val);

            for (int i = 0; i < qsize; i++) {
                TreeNode rmn = mq.remove();
                if (rmn.left != null) {
                    mq.add(rmn.left);
                }

                if (rmn.right != null) {
                    mq.add(rmn.right);
                }
            }
        }

        return ans;
    }

    // GFG
    // ArrayList<Integer> leftView(Node root)
    // {
    // if(root == null) return new ArrayList<>();
    // ArrayList<Integer> ans = new ArrayList<>();

    // LinkedList<Node> mq = new LinkedList<>();
    // mq.addLast(root);

    // while(mq.size() > 0){
    // int qsize = mq.size();

    // Node node = mq.getFirst();
    // ans.add(node.data);

    // for(int i = 0 ; i < qsize ; i++){
    // Node rmn = mq.removeFirst();
    // if(rmn.left != null){
    // mq.addLast(rmn.left);
    // }

    // if(rmn.right != null){
    // mq.addLast(rmn.right);
    // }
    // }
    // }

    // return ans;
    // }
}
