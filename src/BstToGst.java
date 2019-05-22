import Objects.TreeNode;

public class BstToGst {

    public static void main(String[] args) {
        bstToGst(Util.createTreeFromArray(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8}));
    }

    public static TreeNode bstToGst(TreeNode root) {
        return (TreeNode) bstToGstHelper(root, 0)[0];
    }

    private static Object[] bstToGstHelper(TreeNode root, int maxRight) {
        if (root == null) return null;
        if (root.right == null && root.left == null) {
            root.val += maxRight;
            return new Object[]{root, root.val};
        }

        if (root.right != null) {
            Object[] temp = bstToGstHelper(root.right, maxRight);
            root.val += Math.max(((TreeNode) temp[0]).val, (int) temp[1]);
        }
        Object[] temp = null;
        if (root.left != null) temp = bstToGstHelper(root.left, root.val);
        return new Object[]{root, Math.max(root.val, temp != null ? (int) temp[1] : -1)};
    }
}
