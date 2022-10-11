package BinaryTree.Level_2;

public class BurningTree {
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

    public static int maxTime = 0;

    public static int minTime(Node root, int target) {
        nodeToRootPath(root, target);
        return maxTime;
    }

    public static int nodeToRootPath(Node root, int target) {
        if (root == null)
            return -1;

        if (root.data == target) {
            burnTree(root, null, 0);
            return 1;
        }

        int leftTime = nodeToRootPath(root.left, target);
        if (leftTime != -1) {
            burnTree(root, root.left, leftTime);
            return leftTime + 1;
        }

        int rightTime = nodeToRootPath(root.right, target);
        if (rightTime != -1) {
            burnTree(root, root.right, rightTime);
            return rightTime + 1;
        }

        return -1;
    }

    public static void burnTree(Node root, Node blockerNode, int time) {
        if (root == null || root == blockerNode)
            return;

        maxTime = Math.max(maxTime, time);

        burnTree(root.left, blockerNode, time + 1);
        burnTree(root.right, blockerNode, time + 1);
    }
}
