import apple.laf.JRSUIUtils;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;

        if(root.val < L) return rangeSumBST(root.right, L, R);
        if(root.val > R) return rangeSumBST(root.left, L, R);
        return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + root.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}