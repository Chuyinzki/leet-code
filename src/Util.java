import Objects.TreeNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Util {
    public static TreeNode getBasicTree() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        return t1;
    }

    public static TreeNode createTreeFromArray(Integer[] array) {
        Queue<TreeNode> order = new ArrayDeque<>();
        TreeNode ret = new TreeNode(array[0]);
        order.add(ret);
        for (int i = 1; i < array.length; i+=2) {
            TreeNode curNode = order.poll();
            if (array[i] != null) {
                curNode.left = new TreeNode(array[i]);
                order.add(curNode.left);
            }
            if (i + 1 < array.length && array[i + 1] != null) {
                curNode.right = new TreeNode(array[i + 1]);
                order.add(curNode.right);
            }
        }
        return ret;
    }
}
