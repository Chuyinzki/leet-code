import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> leftList = inorderTraversal(root.left);
        List<Integer> rightList = inorderTraversal(root.right);
        List<Integer> ret = new ArrayList<>();
        ret.addAll(leftList);
        ret.add(root.val);
        ret.addAll(rightList);
        return ret;
    }
}
