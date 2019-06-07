import Objects.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        levelOrder(Util.getBasicTree());
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Object[]> nodes = new ArrayList<>();
        int cur = 0;
        nodes.add(new Object[]{root, cur});
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        while (!nodes.isEmpty()) {
            Object[] obj = nodes.remove(0);
            TreeNode curNode = (TreeNode) obj[0];
            Integer num = (Integer) obj[1];
            if (curNode.left != null) {
                nodes.add(new Object[]{curNode.left, num + 1});
            }
            if (curNode.right != null) {
                nodes.add(new Object[]{curNode.right, num + 1});
            }
            if (cur == num) {
                curList.add(curNode.val);
            } else {
                ret.add(new ArrayList<>(curList));
                curList.clear();
                curList.add(curNode.val);
                cur = num;
            }
        }
        ret.add(new ArrayList<>(curList));
        return ret;
    }
}
