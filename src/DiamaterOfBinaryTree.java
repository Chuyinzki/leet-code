import Objects.TreeNode;

public class DiamaterOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(Util.createTreeFromArray(new Integer[]{3, 1, null, null, 2})));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return diameterOfBinaryTree(root.left) + diameterOfBinaryTree(root.right) + 1;
    }
}
