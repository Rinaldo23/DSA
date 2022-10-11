package BinaryTree.Level_2;

import java.util.ArrayList;

public class BurningTree2 {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    public static ArrayList<ArrayList<Integer>> BurningTree(Node root, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        nodeToRootPath(root, target, ans);
        return ans;
    }

    public static int nodeToRootPath(Node root, int target, ArrayList<ArrayList<Integer>> ans) {
        if (root == null)
            return -1;

        if (root.data == target) {
            burnTree(root, null, 0, ans);
            return 1;
        }

        int leftTime = nodeToRootPath(root.left, target, ans);
        if (leftTime != -1) {
            burnTree(root, root.left, leftTime, ans);
            return leftTime + 1;
        }

        int rightTime = nodeToRootPath(root.right, target, ans);
        if (rightTime != -1) {
            burnTree(root, root.right, rightTime, ans);
            return rightTime + 1;
        }

        return -1;
    }

    public static void burnTree(Node root, Node blockerNode, int time, ArrayList<ArrayList<Integer>> ans) {
        if (root == null || root == blockerNode)
            return;

        if(time == ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(time).add((root.data));  // Important Line 

        burnTree(root.left, blockerNode, time + 1, ans);
        burnTree(root.right, blockerNode, time + 1, ans);
    }
}
