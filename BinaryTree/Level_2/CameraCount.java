package BinaryTree.Level_2;

public class CameraCount {
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

    class Solution {
        public int cameras = 0;

        public int minCameraCover(TreeNode root) {

            // if(cameraCount(root) == -1) cameras++;
            int rres = cameraCount(root);
            if (rres == -1) {
                cameras++;
            }
            return cameras;
        }

        public int cameraCount(TreeNode root) {
            if (root == null) {
                return 1;
            }

            int lc = cameraCount(root.left);
            int rc = cameraCount(root.right);

            if (lc == -1 || rc == -1) {
                cameras++;
                return 0;
            }

            if (lc == 0 || rc == 0) {
                return 1;
            }

            return -1;
        }
    }
}
