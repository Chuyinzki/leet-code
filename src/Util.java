import Objects.TreeNode;

public class Util {
    public static TreeNode getBasicTree() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        return t1;
    }
}
