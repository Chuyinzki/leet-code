package Objects;

public class Node<T> {

    public Node left;
    public Node right;
    public T data;

    public Node(Node left, Node right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node(T data) {
        this(null, null, data);
    }
}
