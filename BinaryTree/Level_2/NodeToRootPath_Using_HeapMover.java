package BinaryTree.Level_2;

import java.util.ArrayList;

public class NodeToRootPath_Using_HeapMover {
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

    public static boolean findData(TreeNode node, int data, ArrayList<TreeNode> list) {
        if (node == null) {
            return false;
        }

        if (node.val == data) {
            list.add(node);
            return true;
        }

        boolean filc = findData(node.left, data, list);
        if (filc) {
            list.add(node);
            return true;
        }

        boolean firc = findData(node.right, data, list);
        if (firc) {
            list.add(node);
            return true;
        }

        return false;
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int data){
        ArrayList<TreeNode> list = new ArrayList<>();
        findData(root, data, list);
        return list;
    }
}
