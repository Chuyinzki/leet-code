import java.util.ArrayList;
import java.util.List;

public class NodeTraversals {

    // 0, 1, 2, 3, null, 5, 6, 7, null, null, 10
    /*
    *                       0
    *           1                         2
    *       3      null                 5   6
    *     7   null
    * */

    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, null, 5, 6, 7, null, null, 10};
        Node<Integer> root = createNodes(arr);
        System.out.println();

    }

    public static <T> Node<T> createNodes(T[] objects) {
        List<Node<T>> insertOrdered = new ArrayList<>();
        Node<T> rootRet = new Node<>(objects[0]);
        insertOrdered.add(rootRet);
        for (int i = 1; i < objects.length; i+=2) {
            Node<T> parent = insertOrdered.remove(0);
            Node<T> left = new Node<>(objects[i]);
            insertOrdered.add(left);
            parent.left = left;
            if(i + 1 < objects.length) {
                Node<T> right = new Node<>(objects[i + 1]);
                insertOrdered.add(right);
                parent.right = right;
            }
        }
        return rootRet;
    }

}
