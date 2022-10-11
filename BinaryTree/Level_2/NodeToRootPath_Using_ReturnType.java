package BinaryTree.Level_2;

import java.util.*;

public class NodeToRootPath_Using_ReturnType {
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

    public static ArrayList<TreeNode> nodeToRootPath_(TreeNode node, int data) {
        if (node == null) {
            return null;
        }

        if (node.val == data) {
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        }

        ArrayList<TreeNode> filc = nodeToRootPath_(node.left, data);
        if (filc != null) {
            filc.add(node);
            return filc;
        }

        ArrayList<TreeNode> firc = nodeToRootPath_(node.right, data);
        if (firc != null) {
            firc.add(node);
            return firc;
        }

        return null;
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
        ArrayList<TreeNode> res = nodeToRootPath_(node, data);
        return res != null ? res : new ArrayList<>();
    }
}
