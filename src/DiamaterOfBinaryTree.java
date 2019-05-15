import Objects.TreeNode;

public class DiamaterOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(Util.createTreeFromArray(new Integer[]{3, 1, null, null, 2})));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] minMax = diameterOfBinaryTree(root, 0);
        return Math.abs(minMax[0] - minMax[1]);
    }

    public static int[] diameterOfBinaryTree(TreeNode root, int curScore) {
        int[] ret = new int[]{curScore, curScore};
        if (root.right != null) {
            int[] right = diameterOfBinaryTree(root.right, curScore + 1);
            ret[0] = Math.min(Math.min(ret[0], right[0]), right[1]);
            ret[1] = Math.max(Math.max(ret[1], right[0]), right[1]);
        }
        if (root.left != null) {
            int[] left = diameterOfBinaryTree(root.left, curScore - 1);
            ret[0] = Math.min(Math.min(ret[0], left[0]), left[1]);
            ret[1] = Math.max(Math.max(ret[1], left[0]), left[1]);
        }
        return ret;
    }
}
