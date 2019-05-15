public class MergeTrees {

    public static void main(String[] args) {
        TreeNode t1 = Util.getBasicTree();

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        mergeTrees(t1, t2);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode retNode = new TreeNode((t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0));
        retNode.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        retNode.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        return retNode;
    }
}
