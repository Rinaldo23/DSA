package BinaryTree.Level_2;

import java.util.*;

public class AddOneRowToTree extends MAIN {
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return addOneRow_(root, val, depth);
    }

    public TreeNode addOneRow_(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> mq = new ArrayDeque<>();
        mq.add(root);

        while (depth-- > 2) {
            int size = mq.size();
            while (size-- > 0) {
                TreeNode node = mq.remove();

                if (node.left != null)
                    mq.add(node.left);

                if (node.right != null)
                    mq.add(node.right);
            }
        }

        while (mq.size() > 0) {
            TreeNode node = mq.remove();

            TreeNode tempLeft = node.left;
            node.left = new TreeNode(val);
            node.left.left = tempLeft;

            TreeNode tempRight = node.right;
            node.right = new TreeNode(val);
            node.right.right = tempRight;
        }

        return root;
    }
}