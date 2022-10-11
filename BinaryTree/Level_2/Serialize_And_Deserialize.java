package BinaryTree.Level_2;

public class Serialize_And_Deserialize {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize_(root, sb);
        return sb.toString();
    }

    public void serialize_(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");

        serialize_(root.left, sb);
        serialize_(root.right, sb);
    }

    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");
        return deserialize_(arr);
    }

    int idx = 0;

    public TreeNode deserialize_(String[] data) {
        if (idx >= data.length || data[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[idx++]));

        root.left = deserialize_(data);
        root.right = deserialize_(data);

        return root;
    }
}
