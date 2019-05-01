import java.util.ArrayList;
import java.util.List;

public class NodeTraversals {

    // 0, 1, 2, 3, null, 5, 6, 7, null, null, 10
    /*
     *                       0
     *           1                            2
     *       3      null                 5           6
     *     7   null                  null  10
     * */

    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, null, 5, 6, 7, null, null, 10};
        Node<Integer> root = createNodes(arr);

        System.out.println("In order traversal:");
        inOrderTraverse(root);
        spaceOut(5);

        System.out.println("Pre order traversal:");
        preOrderTraverse(root);
        spaceOut(5);

    }

    public static <T> void postOrderTraverse(Node<T> root) {

    }

    public static <T> void preOrderTraverse(Node<T> root) {
        if (root == null) return;

        System.out.println(root.data);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public static <T> void inOrderTraverse(Node<T> root) {
        if (root == null) return;

        inOrderTraverse(root.left);
        System.out.println(root.data);
        inOrderTraverse(root.right);
    }

    public static void spaceOut(int numTimes) {
        for (int i = 0; i < numTimes; i++)
            System.out.println();
    }

    public static <T> Node<T> createNodes(T[] objects) {
        List<Node<T>> insertOrdered = new ArrayList<>();
        Node<T> rootRet = new Node<>(objects[0]);
        insertOrdered.add(rootRet);
        for (int i = 1; i < objects.length; i += 2) {
            Node<T> parent = insertOrdered.remove(0);
            Node<T> left = new Node<>(objects[i]);
            if (left.data != null) {
                insertOrdered.add(left);
                parent.left = left;
            }
            if (i + 1 < objects.length) {
                Node<T> right = new Node<>(objects[i + 1]);
                if (right.data != null) {
                    insertOrdered.add(right);
                    parent.right = right;
                }
            }
        }
        return rootRet;
    }

}
