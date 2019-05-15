import Objects.ListNode;

import java.util.Stack;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode returnHead = stack.pop();
        head = returnHead;
        while (!stack.isEmpty()) {
            head.next = stack.pop();
            head = head.next;
        }
        head.next = null;
        return returnHead;
    }
}
