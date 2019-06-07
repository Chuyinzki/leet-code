import Objects.TreeNode;

public class InvertTree {

    public static void main(String[] args) {
        invertTree(Util.getBasicTree());
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }
}
