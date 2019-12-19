import Objects.TreeNode;

public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode rootPointer = root;
        while(root != null) {
            if(val > root.val) {
                if(root.right == null) {
                    root.right = new TreeNode(val);
                    return rootPointer;
                }
                else
                    root = root.right;
            } else {
                if(root.left == null) {
                    root.left = new TreeNode(val);
                    return rootPointer;
                }
                else
                    root = root.left;
            }
        }
        return rootPointer;
    }
}
